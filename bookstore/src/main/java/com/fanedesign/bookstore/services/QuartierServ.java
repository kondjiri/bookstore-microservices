package com.fanedesign.bookstore.services;

import com.fanedesign.bookstore.models.Pays;
import com.fanedesign.bookstore.models.Quartier;
import com.fanedesign.bookstore.repositories.PaysRepo;
import com.fanedesign.bookstore.repositories.QuartierRepo;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartierServ {

    @Autowired
    private QuartierRepo quartierRepo;


    public ResponseHttp findAll(){
        List<Quartier> quartiers = quartierRepo.findAll(Sort.by(Sort.Direction.ASC,"name"));
        if (quartiers.isEmpty()){
            return new ResponseHttp("OK",200,"Vous n'avez pas de Quartier",quartiers);
        }
        return new ResponseHttp("OK",200,quartiers.size()+" Quartiers Trouvés",quartiers);
    }

    public ResponseHttp save(Quartier quartier){
        Quartier quartier1 = quartierRepo.save(quartier);
        if (quartier1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la création du Quartier",null);
        }
        return new ResponseHttp("OK",200,"Quartier sauvegardée avec succès",null);
    }

    public ResponseHttp update(Quartier quartier){
        Quartier quartier1  = quartierRepo.save(quartier);
        if (quartier1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la mise à jour du Quartier",null);
        }
        return new ResponseHttp("OK",200,"Quartier mise en jour avec succès",null);
    }


    public ResponseHttp delete(String _id){
        quartierRepo.deleteById(_id);
        return new ResponseHttp("OK",200,"Quarier Supprimé avec succès",null);
    }
}
