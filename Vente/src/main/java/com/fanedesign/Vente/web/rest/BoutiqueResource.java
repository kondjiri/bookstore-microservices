package com.fanedesign.Vente.web.rest;

import com.fanedesign.Vente.domaine.Boutique;
import com.fanedesign.Vente.repository.BoutiqueRepository;
import com.fanedesign.Vente.service.BoutiqueService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing {@link com.fanedesign.Vente.domaine.Boutique}.
 */
@RestController
@RequestMapping("/api")
public class BoutiqueResource {

    private final Logger log = LoggerFactory.getLogger(BoutiqueResource.class);

    private static final String ENTITY_NAME = "boutique";

    private final BoutiqueService boutiqueService;

    private final BoutiqueRepository boutiqueRepository;

    public BoutiqueResource(BoutiqueService boutiqueService, BoutiqueRepository boutiqueRepository) {
        this.boutiqueService = boutiqueService;
        this.boutiqueRepository = boutiqueRepository;
    }

    /**
     * {@code POST  /boutiques} : Create a new boutique.
     *
     * @param boutique the boutique to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new boutique, or with status {@code 400 (Bad Request)} if the boutique has already an ID.

     */
    @PostMapping("/boutiques")
    public Boutique createBoutique(@RequestBody Boutique boutique) {
        log.debug("REST request to save Boutique : {}", boutique);

        return boutiqueService.save(boutique);
    }

    /**
     * {@code PUT  /boutiques/:id} : Updates an existing boutique.
     *
     * @param id the id of the boutique to save.
     * @param boutique the boutique to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated boutique,
     * or with status {@code 400 (Bad Request)} if the boutique is not valid,
     * or with status {@code 500 (Internal Server Error)} if the boutique couldn't be updated.

     */
    @PutMapping("/boutiques/{id}")
    public Boutique updateBoutique(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Boutique boutique
    )  {
        log.debug("REST request to update Boutique : {}, {}", id, boutique);

        return boutiqueService.save(boutique);
    }



    /**
     * {@code GET  /boutiques} : get all the boutiques.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of boutiques in body.
     */
    @GetMapping("/boutiques")
    public List<Boutique> getAllBoutiques() {
        log.debug("REST request to get all Boutiques");
        return boutiqueService.findAll();
    }


//    @GetMapping("/boutiques/{id}")
//    public Boutique getBoutique(@PathVariable Long id) {
//        log.debug("REST request to get Boutique : {}", id);
//
//        return boutiqueService.findOne(id);
//    }

    /**
     * {@code DELETE  /boutiques/:id} : delete the "id" boutique.
     *
     * @param id the id of the boutique to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/boutiques/{id}")
    public void deleteBoutique(@PathVariable Long id) {
        log.debug("REST request to delete Boutique : {}", id);
        boutiqueService.delete(id);

    }
}
