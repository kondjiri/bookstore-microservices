package com.fanedesign.bookstore.repositories;

import com.fanedesign.bookstore.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author,String> {
}
