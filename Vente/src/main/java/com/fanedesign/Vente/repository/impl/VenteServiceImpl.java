package com.fanedesign.Vente.repository.impl;

import com.fanedesign.Vente.domaine.Vente;
import com.fanedesign.Vente.repository.VenteRepository;
import com.fanedesign.Vente.service.VenteService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Vente}.
 */
@Service
@Transactional
public class VenteServiceImpl implements VenteService {

    private final Logger log = LoggerFactory.getLogger(VenteServiceImpl.class);

    private final VenteRepository venteRepository;

    public VenteServiceImpl(VenteRepository venteRepository) {
        this.venteRepository = venteRepository;
    }

    @Override
    public Vente save(Vente vente) {
        log.debug("Request to save Vente : {}", vente);
        return venteRepository.save(vente);
    }

    @Override
    public Optional<Vente> partialUpdate(Vente vente) {
        log.debug("Request to partially update Vente : {}", vente);

        return venteRepository
            .findById(vente.getId())
            .map(existingVente -> {
                if (vente.getPrix() != null) {
                    existingVente.setPrix(vente.getPrix());
                }

                return existingVente;
            })
            .map(venteRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vente> findAll() {
        log.debug("Request to get all Ventes");
        return venteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Vente> findOne(Long id) {
        log.debug("Request to get Vente : {}", id);
        return venteRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Vente : {}", id);
        venteRepository.deleteById(id);
    }
}
