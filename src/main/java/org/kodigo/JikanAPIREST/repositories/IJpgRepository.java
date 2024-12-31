package org.kodigo.JikanAPIREST.repositories;

import org.kodigo.JikanAPIREST.entities.Jpg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJpgRepository extends JpaRepository<Jpg, Long> {
}
