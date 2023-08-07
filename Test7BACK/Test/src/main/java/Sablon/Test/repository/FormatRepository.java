package Sablon.Test.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Sablon.Test.model.Format;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long>{

	Format findOneById(Long id);
	
	//Format findAll(Long id);
	
	
}
