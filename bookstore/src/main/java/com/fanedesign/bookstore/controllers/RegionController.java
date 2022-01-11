package com.fanedesign.bookstore.controllers;

import com.fanedesign.bookstore.models.Cercle;
import com.fanedesign.bookstore.models.Region;
import com.fanedesign.bookstore.services.CercleServ;
import com.fanedesign.bookstore.services.RegionServ;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/region")
public class RegionController {


    @Autowired
    private RegionServ regionServ;


    @GetMapping("/all")
    public ResponseHttp findAll(){
        return regionServ.findAll();
    }
    @PostMapping("/save")
    public ResponseHttp save(@RequestBody Region region){
        return regionServ.save(region);
    }

    @GetMapping("/delete")
    public ResponseHttp delete(@PathVariable String _id){
        return regionServ.delete(_id);
    }

    @PostMapping("/update")
    public ResponseHttp update(@RequestBody Region region){
        return  regionServ.update(region);
    }
}
