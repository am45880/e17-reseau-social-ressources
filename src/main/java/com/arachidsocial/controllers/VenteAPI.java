package com.arachidsocial.controllers;

import com.arachidsocial.models.Ticket;
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
@RequestMapping("/api/vente/")
public class VenteAPI {

    @Autowired
    UserRepository userRepository;

    //Petit exemple rapide pour le site de vente 1 qui veut recuperer les tikets de son utilisateur authentifie
    //1. curl -XPOST -u vente1:pass1 arachid.me:9999/oauth/token -d grant_type=password -d username=obama@gmail.com -d password=secret123
    //2. curl -H 'Authorization: Bearer eybmghjkhjkAD9rB6hy... Le  long JWT (access_token) obtenu a l<etape 1 ...mYZGv7qghjkdryulG-hYFXozw' localhost:7777/api/vente/user/tickets
    @GetMapping("/user/tickets")
    public ArrayList<Ticket> getMyRole(Authentication authentication){
        return userRepository.findByUsername(authentication.getName()).getTickets();
    }



}
