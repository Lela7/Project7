package Sablon.Test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Sablon.Test.model.Prijava;

@Repository
public interface PrijavaRepository extends JpaRepository<Prijava, Long>{

	Prijava findOneById (Long id);
}
