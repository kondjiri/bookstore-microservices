package com.fanedesign.bookstore.controllers;

import com.fanedesign.bookstore.models.Commune;
import com.fanedesign.bookstore.models.Pays;
import com.fanedesign.bookstore.services.CommuneServ;
import com.fanedesign.bookstore.services.PaysServ;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pays")
public class PyasController {



    @Autowired
    private PaysServ paysServ;


    @GetMapping("/all")
    public ResponseHttp findAll(){
        return paysServ.findAll();
    }
    @PostMapping("/save")
    public ResponseHttp save(@RequestBody Pays pays){
        return paysServ.save(pays);
    }

    @GetMapping("/delete")
    public ResponseHttp delete(@PathVariable String _id){
        return paysServ.delete(_id);
    }

    @PostMapping("/update")
    public ResponseHttp update(@RequestBody Pays pays){
        return  paysServ.update(pays);
    }
}
