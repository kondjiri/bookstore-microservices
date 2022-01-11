package com.fanedesign.bookstore.repositories;

import com.fanedesign.bookstore.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepo extends JpaRepository<Address,String> {
}
