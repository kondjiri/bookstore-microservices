package com.fanedesign.bookstore.controllers;

import com.fanedesign.bookstore.models.Commune;
import com.fanedesign.bookstore.models.Region;
import com.fanedesign.bookstore.services.CommuneServ;
import com.fanedesign.bookstore.services.RegionServ;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commune")
public class CommuneController {


    @Autowired
    private CommuneServ communeServ;


    @GetMapping("/all")
    public ResponseHttp findAll(){
        return communeServ.findAll();
    }
    @PostMapping("/save")
    public ResponseHttp save(@RequestBody Commune commune){
        return communeServ.save(commune);
    }

    @GetMapping("/delete")
    public ResponseHttp delete(@PathVariable String _id){
        return communeServ.delete(_id);
    }

    @PostMapping("/update")
    public ResponseHttp update(@RequestBody Commune commune){
        return  communeServ.update(commune);
    }
}
