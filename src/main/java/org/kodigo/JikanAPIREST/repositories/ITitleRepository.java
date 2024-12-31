package org.kodigo.JikanAPIREST.repositories;

import org.kodigo.JikanAPIREST.entities.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITitleRepository extends JpaRepository<Title, Long> {
}
