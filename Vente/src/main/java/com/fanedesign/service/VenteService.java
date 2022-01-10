package com.fanedesign.service;

import com.fanedesign.domain.Vente;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Vente}.
 */
public interface VenteService {
    /**
     * Save a vente.
     *
     * @param vente the entity to save.
     * @return the persisted entity.
     */
    Vente save(Vente vente);

    /**
     * Partially updates a vente.
     *
     * @param vente the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Vente> partialUpdate(Vente vente);

    /**
     * Get all the ventes.
     *
     * @return the list of entities.
     */
    List<Vente> findAll();

    /**
     * Get the "id" vente.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Vente> findOne(Long id);

    /**
     * Delete the "id" vente.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
