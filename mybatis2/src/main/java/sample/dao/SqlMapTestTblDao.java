package sample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import sample.biz.dao.TestTblDao;
import sample.biz.domain.TestTbl;

@Repository
public class SqlMapTestTblDao implements TestTblDao {

    @Autowired
    private SqlMapClientTemplate template;

    public TestTbl getTestTbl(Integer id, String name) {
        TestTbl cond = new TestTbl();
        cond.setId(id);
        cond.setName(name);
        return (TestTbl) template.queryForObject("findTestTbl", cond);
    }

}

