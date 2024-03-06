package com.vv.repository;

import com.vv.domain.VVItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VVRepository extends JpaRepository<VVItem, String> {
    public Optional<VVItem> findByName( String name );
}
