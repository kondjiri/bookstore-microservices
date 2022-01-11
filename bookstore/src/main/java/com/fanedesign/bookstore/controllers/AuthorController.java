package com.fanedesign.bookstore.controllers;

import com.fanedesign.bookstore.models.Address;
import com.fanedesign.bookstore.models.Author;
import com.fanedesign.bookstore.services.AdressServ;
import com.fanedesign.bookstore.services.AuthorServ;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private AuthorServ authorServ;


    @GetMapping("/all")
    public ResponseHttp findAll(){
        return authorServ.findAll();
    }
    @PostMapping("/save")
    public ResponseHttp save(@RequestBody Author author){
        return authorServ.save(author);
    }

    @GetMapping("/delete")
    public ResponseHttp delete(@PathVariable String _id){
        return authorServ.delete(_id);
    }

    @PostMapping("/update")
    public ResponseHttp update(@RequestBody Author author){
        return  authorServ.update(author);
    }
}
