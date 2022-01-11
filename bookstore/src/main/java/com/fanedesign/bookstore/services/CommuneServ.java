package com.fanedesign.bookstore.services;

import com.fanedesign.bookstore.models.Cercle;
import com.fanedesign.bookstore.models.Commune;
import com.fanedesign.bookstore.repositories.CercleRepo;
import com.fanedesign.bookstore.repositories.CommuneRepo;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuneServ {


    @Autowired
    private CommuneRepo communeRepo;


    public ResponseHttp findAll(){
        List<Commune> communes = communeRepo.findAll(Sort.by(Sort.Direction.ASC,"name"));
        if (communes.isEmpty()){
            return new ResponseHttp("OK",200,"Vous n'avez pas de Commune",communes);
        }
        return new ResponseHttp("OK",200,communes.size()+" Commune Trouvés",communes);
    }

    public ResponseHttp save(Commune commune){
        Commune commune1 = communeRepo.save(commune);
        if (commune1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la création dE LA Commune",null);
        }
        return new ResponseHttp("OK",200,"Commune sauvegardée avec succès",null);
    }

    public ResponseHttp update(Commune commune){
        Commune commune1  = communeRepo.save(commune);
        if (commune1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la mise à jour d'u commune",null);
        }
        return new ResponseHttp("OK",200,"Commune mise en jour avec succès",null);
    }


    public ResponseHttp delete(String _id){
        communeRepo.deleteById(_id);
        return new ResponseHttp("OK",200,"Commune Supprimé avec succès",null);
    }
}
