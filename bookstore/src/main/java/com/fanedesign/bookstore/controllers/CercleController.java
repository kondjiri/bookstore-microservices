package com.fanedesign.bookstore.controllers;

import com.fanedesign.bookstore.models.Book;
import com.fanedesign.bookstore.models.Cercle;
import com.fanedesign.bookstore.services.BookServ;
import com.fanedesign.bookstore.services.CercleServ;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cercle")
public class CercleController {


    @Autowired
    private CercleServ cercleServ;


    @GetMapping("/all")
    public ResponseHttp findAll(){
        return cercleServ.findAll();
    }
    @PostMapping("/save")
    public ResponseHttp save(@RequestBody Cercle cercle){
        return cercleServ.save(cercle);
    }

    @GetMapping("/delete")
    public ResponseHttp delete(@PathVariable String _id){
        return cercleServ.delete(_id);
    }

    @PostMapping("/update")
    public ResponseHttp update(@RequestBody Cercle cercle){
        return  cercleServ.update(cercle);
    }
}
