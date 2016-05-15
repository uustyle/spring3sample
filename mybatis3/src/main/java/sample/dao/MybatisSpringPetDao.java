package sample.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sample.biz.dao.PetDao;
import sample.biz.domain.Pet;

@Repository
public class MybatisSpringPetDao implements PetDao {
    @Autowired
    private SqlSession session;

    public Pet findPetById(int id) {
        return session.selectOne("sample.dao.PetMapper.selectPet", id);
    }
}
