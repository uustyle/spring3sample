package sample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sample.biz.dao.PetDao;
import sample.biz.domain.Pet;
import sample.dao.tmp.PetMapper;

@Repository
public class MybatisSpringMapperPetDao implements PetDao {
    @Autowired
    private PetMapper petMapper;

    public Pet findPetById(int id) {
        return petMapper.selectPet(id);
    }
}
