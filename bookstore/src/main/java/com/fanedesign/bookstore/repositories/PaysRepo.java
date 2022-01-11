package com.fanedesign.bookstore.repositories;

import com.fanedesign.bookstore.models.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysRepo extends JpaRepository<Pays,String> {
}
