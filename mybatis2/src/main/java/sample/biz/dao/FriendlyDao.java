package sample.biz.dao;

import java.util.List;

import sample.biz.domain.Owner;

public interface FriendlyDao {
    Owner getOwnerDynamic(String id, String name);
    void insertOwner(Owner owner);
    void deleteOwner(String id);
    
}
