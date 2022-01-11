package com.fanedesign.bookstore.repositories;

import com.fanedesign.bookstore.models.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuneRepo extends JpaRepository<Commune,String> {
}
