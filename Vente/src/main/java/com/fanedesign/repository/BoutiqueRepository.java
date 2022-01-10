package com.fanedesign.repository;

import com.fanedesign.domain.Boutique;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Boutique entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique, Long> {}
