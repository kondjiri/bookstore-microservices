package com.fanedesign.bookstore.controllers;

import com.fanedesign.bookstore.models.Address;
import com.fanedesign.bookstore.models.Author;
import com.fanedesign.bookstore.services.AdressServ;
import com.fanedesign.bookstore.services.AuthorServ;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/adresse")
public class AdressController {

    @Autowired
    private AdressServ adressServ;


    @GetMapping("/all")
    public ResponseHttp findAll(){
        return adressServ.findAll();
    }
    @PostMapping("/save")
    public ResponseHttp save(@RequestBody Address address){
        return adressServ.save(address);
    }

    @GetMapping("/delete")
    public ResponseHttp delete(@PathVariable String _id){
        return adressServ.delete(_id);
    }

    @PostMapping("/update")
    public ResponseHttp update(@RequestBody Address address){
        return  adressServ.update(address);
    }
}
