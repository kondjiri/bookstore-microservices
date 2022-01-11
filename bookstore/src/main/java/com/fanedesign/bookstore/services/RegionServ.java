package com.fanedesign.bookstore.services;

import com.fanedesign.bookstore.models.Quartier;
import com.fanedesign.bookstore.models.Region;
import com.fanedesign.bookstore.repositories.QuartierRepo;
import com.fanedesign.bookstore.repositories.RegionRepo;
import com.fanedesign.bookstore.utils.ResponseHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServ {

    @Autowired
    private RegionRepo regionRepo;


    public ResponseHttp findAll(){
        List<Region> regions = regionRepo.findAll(Sort.by(Sort.Direction.ASC,"name"));
        if (regions.isEmpty()){
            return new ResponseHttp("OK",200,"Vous n'avez pas de Quartier",regions);
        }
        return new ResponseHttp("OK",200,regions.size()+" Quartiers Trouvés",regions);
    }

    public ResponseHttp save(Region region){
        Region region1 = regionRepo.save(region);
        if (region1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la création du Quartier",null);
        }
        return new ResponseHttp("OK",200,"Quartier sauvegardée avec succès",null);
    }

    public ResponseHttp update(Region region){
        Region region1  = regionRepo.save(region);
        if (region1==null){
            return new ResponseHttp("KO",400,"Erreur lors de la mise à jour du Quartier",null);
        }
        return new ResponseHttp("OK",200,"Quartier mise en jour avec succès",null);
    }


    public ResponseHttp delete(String _id){
        regionRepo.deleteById(_id);
        return new ResponseHttp("OK",200,"Quarier Supprimé avec succès",null);
    }
}
