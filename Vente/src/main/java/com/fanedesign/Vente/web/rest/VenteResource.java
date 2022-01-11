package com.fanedesign.Vente.web.rest;

import com.fanedesign.Vente.domaine.Vente;
import com.fanedesign.Vente.repository.VenteRepository;
import com.fanedesign.Vente.service.VenteService;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * REST controller for managing {@link com.fanedesign.Vente.domaine.Vente}.
 */
@RestController
@RequestMapping("/api")
public class VenteResource {

    private final Logger log = LoggerFactory.getLogger(VenteResource.class);

    private static final String ENTITY_NAME = "vente";



    private final VenteService venteService;

    private final VenteRepository venteRepository;

    public VenteResource(VenteService venteService, VenteRepository venteRepository) {
        this.venteService = venteService;
        this.venteRepository = venteRepository;
    }

    /**
     * {@code POST  /ventes} : Create a new vente.
     *
     * @param vente the vente to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new vente, or with status {@code 400 (Bad Request)} if the vente has already an ID.

     */
    @PostMapping("/ventes")
    public Vente createVente(@RequestBody Vente vente) {

        return venteService.save(vente);
    }

    /**
     * {@code PUT  /ventes/:id} : Updates an existing vente.
     *

     */
    @PutMapping("/ventes/{id}")
    public Vente updateVente(@PathVariable(value = "id", required = false) final Long id, @RequestBody Vente vente)
        throws URISyntaxException {

        return venteService.save(vente);
    }



    /**
     * {@code GET  /ventes} : get all the ventes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ventes in body.
     */
    @GetMapping("/ventes")
    public List<Vente> getAllVentes() {
        log.debug("REST request to get all Ventes");
        return venteService.findAll();
    }

//    @GetMapping("/ventes/{id}")
//    Vente one(@PathVariable Long id) {
//
//        return venteService.findOne(id);
//
//    }

    /**
     * {@code DELETE  /ventes/:id} : delete the "id" vente.
     *
     * @param id the id of the vente to delete.

     */
    @DeleteMapping("/ventes/{id}")
    public void deleteVente(@PathVariable Long id) {
         venteService.delete(id);

    }
}
