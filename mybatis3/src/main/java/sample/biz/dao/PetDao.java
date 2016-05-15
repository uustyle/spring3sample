package sample.biz.dao;

import sample.biz.domain.Pet;

public interface PetDao {

    Pet findPetById(int id);
}
