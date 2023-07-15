package com.bitlogicsystem.carloanfinance.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitlogicsystem.carloanfinance.app.model.Documents;
import com.bitlogicsystem.carloanfinance.app.repository.DocumentRepository;
import com.bitlogicsystem.carloanfinance.app.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService
{
	@Autowired
	DocumentRepository documentRepository;

	@Override
	public void saveDocument(Documents ldoc) 
	{
		documentRepository.save(ldoc);
	}
}
