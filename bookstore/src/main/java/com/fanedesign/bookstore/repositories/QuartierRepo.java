package com.fanedesign.bookstore.repositories;

import com.fanedesign.bookstore.models.Quartier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartierRepo extends JpaRepository<Quartier,String> {
}
