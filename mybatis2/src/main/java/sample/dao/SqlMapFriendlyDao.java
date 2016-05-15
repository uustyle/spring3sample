package sample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import sample.biz.dao.FriendlyDao;
import sample.biz.domain.Owner;

@Repository
public class SqlMapFriendlyDao implements FriendlyDao {

    @Autowired
    private SqlMapClientTemplate template;

    public Owner getOwnerDynamic(String id, String name) {
        Owner cond = new Owner();
        cond.setOwnerId(id);
        cond.setOwnerName(name);
        return (Owner) template.queryForObject("findOwnerDynamic", cond);
    }

	public void insertOwner(Owner owner) {
		template.insert("insertOwner", owner);
	}

	public void deleteOwner(String id) {
		template.delete("deleteOwner", id);
	}
}

