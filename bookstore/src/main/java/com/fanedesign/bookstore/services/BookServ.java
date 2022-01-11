package com.fanedesign.bookstore.services;

import com.fanedesign.bookstore.models.Author;
import com.fanedesign.bookstore.models.Book;
import com.fanedesign.bookstore.repositories.AuthorRepo;
import com.fanedesign.bookstore.repositories.BookRepo;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServ {

    @Autowired
    private BookRepo bookRepo;


    public ResponseHttp findAll(){
        List<Book> books = bookRepo.findAll(Sort.by(Sort.Direction.ASC,"_createdAt"));
        if (books.isEmpty()){
            return new ResponseHttp("OK",200,"Vous n'avez pas de Livres",books);
        }
        return new ResponseHttp("OK",200,books.size()+" Livres trouvés avec succès",books);
    }

    public ResponseHttp save(Book book){
        Book book1 = bookRepo.save(book);
        if (book1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la création de Livres",null);
        }
        return new ResponseHttp("OK",200,"Livres sauvegardée avec succès",null);
    }

    public ResponseHttp update(Book book){
        Book book1  = bookRepo.save(book);
        if (book1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la mise à jour du LIvre",null);
        }
        return new ResponseHttp("OK",200,"Livres mise en jour avec succès",null);
    }


    public ResponseHttp delete(String _id){
        bookRepo.deleteById(_id);
        return new ResponseHttp("OK",200,"Livre supprimé avec succès ",null);
    }
}
