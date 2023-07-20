package com.bitlogicsystem.carloanfinance.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bitlogicsystem.carloanfinance.app.model.SanctionLetter;

public interface SanctionLetterRepository extends JpaRepository<SanctionLetter, Integer> {
	@Query (value =" SELECT * FROM carloanproject.sanction_letter  Where sanction_id =?1",nativeQuery = true )
	List<SanctionLetter> getAllDataId(int  customerId);

	@Query (value ="SELECT * FROM carloanproject.sanction_letter  Where sanction_id = ?1",nativeQuery = true )
	List<SanctionLetter> getSanctionLetterData(int sacId);

	@Query (value ="SELECT * FROM carloanproject.sanction_letter  Where sanction_id = ?1",nativeQuery = true )
	Optional<SanctionLetter> findBysacId(int sanctionId);

}
