package com.fanedesign.bookstore.repositories;

import com.fanedesign.bookstore.models.Cercle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CercleRepo extends JpaRepository<Cercle,String> {
}
