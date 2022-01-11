package com.fanedesign.bookstore.services;

import com.fanedesign.bookstore.models.Address;
import com.fanedesign.bookstore.repositories.AdressRepo;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressServ {

    @Autowired
    private AdressRepo adressRepo;


    public ResponseHttp findAll(){
        List<Address> addresses = adressRepo.findAll(Sort.by(Sort.Direction.ASC,"name"));
        if (addresses.isEmpty()){
            return new ResponseHttp("OK",200,"Vous n'avez pas d'addresse",addresses);
        }
        return new ResponseHttp("OK",200,addresses.size()+" Addresses Trouvées",addresses);
    }

    public ResponseHttp save(Address address){
            Address address1 = adressRepo.save(address);
            if (address1==null){
                return new ResponseHttp("KO",400,"Erreur lors de la création d'addresse",null);
            }
        return new ResponseHttp("OK",200,"Adresse sauvegardée avec succès",null);
    }

    public ResponseHttp update(Address address){
        Address address1 = adressRepo.save(address);
        if (address1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la mise à jour d'addresse",null);
        }
        return new ResponseHttp("OK",200,"Adresse mise en jour avec succès",null);
    }


    public ResponseHttp delete(String _id){
            adressRepo.deleteById(_id);
            return new ResponseHttp("KO",400,"Erreur lors de la création d'addresse",null);
    }
}
