package com.example.hibernatedemo.repositories;

import com.example.hibernatedemo.models.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRepository extends CrudRepository<Friend, Long> {
    List<Friend> findFriendByName(String name);
    List<Friend> findFriendByPhone(String phone);
    List<Friend> findFriendByEmail(String email);
    List<Friend> findFriendByNameAndPhone(String name, String phone);
}
