package Sablon.Test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Sablon.Test.model.Takmicenje;

@Repository
public interface TakmicenjeRepository extends JpaRepository<Takmicenje, Long> {
	Takmicenje findOneById(Long id);
	
	Page<Takmicenje> findByMestoIgnoreCaseContainsAndFormatId(String mesto, Long formatId, Pageable pageable);

	Page<Takmicenje> findByMestoIgnoreCaseContains(String mesto, Pageable pageable);
}
