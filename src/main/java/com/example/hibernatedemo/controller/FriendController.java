package com.example.hibernatedemo.controller;

import com.example.hibernatedemo.models.Friend;
import com.example.hibernatedemo.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-04-15
 * Time: 10:42
 * Project: hibernateDemo
 * Copyright: MIT
 */
@RestController
@RequestMapping("/friends")
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;

    @GetMapping(path = "/add")
    public String addBook(@RequestParam("name") String name,
                          @RequestParam("phone") String phone,
                          @RequestParam("email") String email){
        Friend f = new Friend();
        f.setName(name);
        f.setPhone(phone);
        f.setEmail(email);
        friendRepository.save(f);
        return "friend added successfully";
    }
    @GetMapping(path = "/all")
    public List<Friend> getAllFriends(){
        return (List<Friend>) friendRepository.findAll();
    }

    @GetMapping(path = "/remove")
    public String removeFriendByName(@RequestParam("name") String name){
        List<Friend> friendToRemove = friendRepository.findFriendByName(name);
        System.out.println(friendToRemove);
        friendRepository.deleteAll(friendToRemove);
        return name + " successfully removed";
    }
}
