package org.kodigo.JikanAPIREST.repositories;

import org.kodigo.JikanAPIREST.entities.Titles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITitlesRepository extends JpaRepository<Titles, Long> {
}
