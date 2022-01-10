package com.fanedesign.web.rest;

import com.fanedesign.domain.Boutique;
import com.fanedesign.repository.BoutiqueRepository;
import com.fanedesign.service.BoutiqueService;
import com.fanedesign.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.fanedesign.domain.Boutique}.
 */
@RestController
@RequestMapping("/api")
public class BoutiqueResource {

    private final Logger log = LoggerFactory.getLogger(BoutiqueResource.class);

    private static final String ENTITY_NAME = "boutique";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

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
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/boutiques")
    public ResponseEntity<Boutique> createBoutique(@RequestBody Boutique boutique) throws URISyntaxException {
        log.debug("REST request to save Boutique : {}", boutique);
        if (boutique.getId() != null) {
            throw new BadRequestAlertException("A new boutique cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Boutique result = boutiqueService.save(boutique);
        return ResponseEntity
            .created(new URI("/api/boutiques/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /boutiques/:id} : Updates an existing boutique.
     *
     * @param id the id of the boutique to save.
     * @param boutique the boutique to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated boutique,
     * or with status {@code 400 (Bad Request)} if the boutique is not valid,
     * or with status {@code 500 (Internal Server Error)} if the boutique couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/boutiques/{id}")
    public ResponseEntity<Boutique> updateBoutique(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Boutique boutique
    ) throws URISyntaxException {
        log.debug("REST request to update Boutique : {}, {}", id, boutique);
        if (boutique.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, boutique.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!boutiqueRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Boutique result = boutiqueService.save(boutique);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, boutique.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /boutiques/:id} : Partial updates given fields of an existing boutique, field will ignore if it is null
     *
     * @param id the id of the boutique to save.
     * @param boutique the boutique to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated boutique,
     * or with status {@code 400 (Bad Request)} if the boutique is not valid,
     * or with status {@code 404 (Not Found)} if the boutique is not found,
     * or with status {@code 500 (Internal Server Error)} if the boutique couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/boutiques/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Boutique> partialUpdateBoutique(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Boutique boutique
    ) throws URISyntaxException {
        log.debug("REST request to partial update Boutique partially : {}, {}", id, boutique);
        if (boutique.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, boutique.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!boutiqueRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Boutique> result = boutiqueService.partialUpdate(boutique);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, boutique.getId().toString())
        );
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

    /**
     * {@code GET  /boutiques/:id} : get the "id" boutique.
     *
     * @param id the id of the boutique to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the boutique, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/boutiques/{id}")
    public ResponseEntity<Boutique> getBoutique(@PathVariable Long id) {
        log.debug("REST request to get Boutique : {}", id);
        Optional<Boutique> boutique = boutiqueService.findOne(id);
        return ResponseUtil.wrapOrNotFound(boutique);
    }

    /**
     * {@code DELETE  /boutiques/:id} : delete the "id" boutique.
     *
     * @param id the id of the boutique to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/boutiques/{id}")
    public ResponseEntity<Void> deleteBoutique(@PathVariable Long id) {
        log.debug("REST request to delete Boutique : {}", id);
        boutiqueService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
