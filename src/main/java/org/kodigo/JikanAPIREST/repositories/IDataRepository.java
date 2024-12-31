package org.kodigo.JikanAPIREST.repositories;

import org.kodigo.JikanAPIREST.entities.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDataRepository extends JpaRepository<Data, Long> {
}
