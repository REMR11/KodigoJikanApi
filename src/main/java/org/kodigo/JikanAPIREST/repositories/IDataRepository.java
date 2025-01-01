package org.kodigo.JikanAPIREST.repositories;

import org.kodigo.JikanAPIREST.entities.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDataRepository extends JpaRepository<Data, Long> {
    Optional<Data> findByUrl(String url);
}
