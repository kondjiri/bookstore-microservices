package com.fanedesign.bookstore.controllers;

import com.fanedesign.bookstore.models.Pays;
import com.fanedesign.bookstore.models.Quartier;
import com.fanedesign.bookstore.services.PaysServ;
import com.fanedesign.bookstore.services.QuartierServ;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quartier")
public class QuartierController {


    @Autowired
    private QuartierServ quartierServ;


    @GetMapping("/all")
    public ResponseHttp findAll(){
        return quartierServ.findAll();
    }
    @PostMapping("/save")
    public ResponseHttp save(@RequestBody Quartier quartier){
        return quartierServ.save(quartier);
    }

    @GetMapping("/delete")
    public ResponseHttp delete(@PathVariable String _id){
        return quartierServ.delete(_id);
    }

    @PostMapping("/update")
    public ResponseHttp update(@RequestBody Quartier quartier){
        return  quartierServ.update(quartier);
    }
}
