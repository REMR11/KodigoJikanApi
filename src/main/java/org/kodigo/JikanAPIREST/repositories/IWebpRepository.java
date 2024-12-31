package org.kodigo.JikanAPIREST.repositories;

import org.kodigo.JikanAPIREST.entities.Webp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWebpRepository extends JpaRepository<Webp, Long> {
}
