package com.fanedesign.bookstore.controllers;

import com.fanedesign.bookstore.models.Address;
import com.fanedesign.bookstore.models.Book;
import com.fanedesign.bookstore.services.AdressServ;
import com.fanedesign.bookstore.services.BookServ;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookServ bookServ;


    @GetMapping("/all")
    public ResponseHttp findAll(){
        return bookServ.findAll();
    }
    @PostMapping("/save")
    public ResponseHttp save(@RequestBody Book book){
        return bookServ.save(book);
    }

    @GetMapping("/delete")
    public ResponseHttp delete(@PathVariable String _id){
        return bookServ.delete(_id);
    }

    @PostMapping("/update")
    public ResponseHttp update(@RequestBody Book book){
        return  bookServ.update(book);
    }
}
