package com.bitlogicsystem.carloanfinance.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bitlogicsystem.carloanfinance.app.model.SanctionLetter;

public interface SanctionLetterRepository extends JpaRepository<SanctionLetter, Integer> {
	@Query (value =" SELECT * FROM carloanproject.sanction_letter  Where sanction_id =?1",nativeQuery = true )
	List<SanctionLetter> getAllDataId(int sanctionid);

}
