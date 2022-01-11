package com.fanedesign.Vente.service;

import com.fanedesign.Vente.domaine.Boutique;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Boutique}.
 */
public interface BoutiqueService {
    /**
     * Save a boutique.
     *
     * @param boutique the entity to save.
     * @return the persisted entity.
     */
    Boutique save(Boutique boutique);

    /**
     * Partially updates a boutique.
     *
     * @param boutique the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Boutique> partialUpdate(Boutique boutique);

    /**
     * Get all the boutiques.
     *
     * @return the list of entities.
     */
    List<Boutique> findAll();

    /**
     * Get the "id" boutique.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Boutique> findOne(Long id);

    /**
     * Delete the "id" boutique.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
