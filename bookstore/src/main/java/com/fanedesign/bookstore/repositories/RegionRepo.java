package com.fanedesign.bookstore.repositories;

import com.fanedesign.bookstore.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<Region,String> {
}
