package com.arachidsocial.controllers;

import com.arachidsocial.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by yassine on 2017-07-02.
 */
@RestController
@RequestMapping("api/mobile")
public class MobileAPI {

    @Autowired
    UserRepository userRepository;

    //Petit exemple rapide pour le site de mobile qui veut recuperer les amis de l'utilisateur
    //1. curl -XPOST -u mobile:pass0 arachid.me:9999/oauth/token -d grant_type=password -d username=obama@gmail.com -d password=secret123
    //2. curl -H 'Authorization: Bearer eybmghjkhjkAD9rB6hy... Le  long JWT (access_token) obtenu a l<etape 1 ...mYZGv7qghjkdryulG-hYFXozw' localhost:7777/api/vente/user/friends
    @GetMapping("/user/friends")
    public ArrayList<String> getMyRole(Authentication authentication){
        return userRepository.findByUsername(authentication.getName()).getFriends();
    }

}
