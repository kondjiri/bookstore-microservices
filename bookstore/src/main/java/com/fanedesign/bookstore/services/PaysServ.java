package com.fanedesign.bookstore.services;

import com.fanedesign.bookstore.models.Commune;
import com.fanedesign.bookstore.models.Pays;
import com.fanedesign.bookstore.repositories.CommuneRepo;
import com.fanedesign.bookstore.repositories.PaysRepo;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaysServ {


    @Autowired
    private PaysRepo paysRepo;


    public ResponseHttp findAll(){
        List<Pays> pays = paysRepo.findAll(Sort.by(Sort.Direction.ASC,"name"));
        if (pays.isEmpty()){
            return new ResponseHttp("OK",200,"Vous n'avez pas de Pays",pays);
        }
        return new ResponseHttp("OK",200,pays.size()+" Pays Trouvés",pays);
    }

    public ResponseHttp save(Pays pays){
        Pays pays1 = paysRepo.save(pays);
        if (pays1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la création du Pays",null);
        }
        return new ResponseHttp("OK",200,"Pays sauvegardée avec succès",null);
    }

    public ResponseHttp update(Pays pays){
        Pays pays1  = paysRepo.save(pays);
        if (pays1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la mise à jour d'u pays",null);
        }
        return new ResponseHttp("OK",200,"Pays mise en jour avec succès",null);
    }


    public ResponseHttp delete(String _id){
        paysRepo.deleteById(_id);
        return new ResponseHttp("OK",200,"Pays Supprimé avec succès",null);
    }
}
