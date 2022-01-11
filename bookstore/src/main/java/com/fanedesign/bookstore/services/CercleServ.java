package com.fanedesign.bookstore.services;

import com.fanedesign.bookstore.models.Author;
import com.fanedesign.bookstore.models.Cercle;
import com.fanedesign.bookstore.repositories.AuthorRepo;
import com.fanedesign.bookstore.repositories.CercleRepo;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CercleServ {


    @Autowired
    private CercleRepo cercleRepo;


    public ResponseHttp findAll(){
        List<Cercle> cercles = cercleRepo.findAll(Sort.by(Sort.Direction.ASC,"name"));
        if (cercles.isEmpty()){
            return new ResponseHttp("OK",200,"Vous n'avez pas de Cercle",cercles);
        }
        return new ResponseHttp("OK",200,cercles.size()+" Cercles Trouvés",cercles);
    }

    public ResponseHttp save(Cercle cercle){
        Cercle cercle1 = cercleRepo.save(cercle);
        if (cercle1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la création du Cercle",null);
        }
        return new ResponseHttp("OK",200,"Cercle sauvegardée avec succès",null);
    }

    public ResponseHttp update(Cercle cercle){
        Cercle cercle1  = cercleRepo.save(cercle);
        if (cercle1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la mise à jour d'u cercle",null);
        }
        return new ResponseHttp("OK",200,"Cercle mise en jour avec succès",null);
    }


    public ResponseHttp delete(String _id){
        cercleRepo.deleteById(_id);
        return new ResponseHttp("OK",200,"Cercle Supprimé avec succès",null);
    }
}
