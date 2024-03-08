package com.vv.repository;

import com.vv.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VVRepository extends JpaRepository<Item, String> {
    public Optional<Item> findByName( String name );
}
