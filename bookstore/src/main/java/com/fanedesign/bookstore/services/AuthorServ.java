package com.fanedesign.bookstore.services;

import com.fanedesign.bookstore.models.Address;
import com.fanedesign.bookstore.models.Author;
import com.fanedesign.bookstore.repositories.AdressRepo;
import com.fanedesign.bookstore.repositories.AuthorRepo;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServ {


    @Autowired
    private AuthorRepo authorRepo;


    public ResponseHttp findAll(){
        List<Author> authors = authorRepo.findAll(Sort.by(Sort.Direction.ASC,"firstName"));
        if (authors.isEmpty()){
            return new ResponseHttp("OK",200,"Vous n'avez pas d'auteur",authors);
        }
        return new ResponseHttp("OK",200,authors.size()+" Auteurs Trouvées",authors);
    }

    public ResponseHttp save(Author author){
        Author author1 = authorRepo.save(author);
        if (author1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la création d'auteur",null);
        }
        return new ResponseHttp("OK",200,"Auteur sauvegardée avec succès",null);
    }

    public ResponseHttp update(Author author){
        Author author1  = authorRepo.save(author);
        if (author1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la mise à jour d'auteur",null);
        }
        return new ResponseHttp("OK",200,"Auteur mise en jour avec succès",null);
    }


    public ResponseHttp delete(String _id){
        authorRepo.deleteById(_id);
        return new ResponseHttp("OK",200,"Livre Supprimé avec succès",null);
    }
}
