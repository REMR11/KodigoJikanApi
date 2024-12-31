package org.kodigo.JikanAPIREST.repositories;

import org.kodigo.JikanAPIREST.entities.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImagesRepository extends JpaRepository<Images, Long> {
}
