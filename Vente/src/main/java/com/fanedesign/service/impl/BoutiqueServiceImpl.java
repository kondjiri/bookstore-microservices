package com.fanedesign.service.impl;

import com.fanedesign.domain.Boutique;
import com.fanedesign.repository.BoutiqueRepository;
import com.fanedesign.service.BoutiqueService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Boutique}.
 */
@Service
@Transactional
public class BoutiqueServiceImpl implements BoutiqueService {

    private final Logger log = LoggerFactory.getLogger(BoutiqueServiceImpl.class);

    private final BoutiqueRepository boutiqueRepository;

    public BoutiqueServiceImpl(BoutiqueRepository boutiqueRepository) {
        this.boutiqueRepository = boutiqueRepository;
    }

    @Override
    public Boutique save(Boutique boutique) {
        log.debug("Request to save Boutique : {}", boutique);
        return boutiqueRepository.save(boutique);
    }

    @Override
    public Optional<Boutique> partialUpdate(Boutique boutique) {
        log.debug("Request to partially update Boutique : {}", boutique);

        return boutiqueRepository
            .findById(boutique.getId())
            .map(existingBoutique -> {
                if (boutique.getNom() != null) {
                    existingBoutique.setNom(boutique.getNom());
                }
                if (boutique.getCreatedAt() != null) {
                    existingBoutique.setCreatedAt(boutique.getCreatedAt());
                }
                if (boutique.getUpdateAt() != null) {
                    existingBoutique.setUpdateAt(boutique.getUpdateAt());
                }

                return existingBoutique;
            })
            .map(boutiqueRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Boutique> findAll() {
        log.debug("Request to get all Boutiques");
        return boutiqueRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Boutique> findOne(Long id) {
        log.debug("Request to get Boutique : {}", id);
        return boutiqueRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Boutique : {}", id);
        boutiqueRepository.deleteById(id);
    }
}
