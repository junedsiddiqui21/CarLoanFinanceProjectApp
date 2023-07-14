package com.bitlogicsystem.carloanfinance.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitlogicsystem.carloanfinance.app.model.SanctionLetter;

public interface SanctionLetterRepository extends JpaRepository<SanctionLetter, Integer> {

}
