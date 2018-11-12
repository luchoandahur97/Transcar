package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.repository.ChoferRepository;
import org.springframework.samples.petclinic.model.Chofer;
import org.springframework.stereotype.Service;

public class ChoferServiceImpl implements ChoferService {
    
	private ChoferRepository choferRepository;

	public ChoferServiceImpl(ChoferRepository choferRepository) {
		// TODO Auto-generated constructor stub
		this.choferRepository=choferRepository;
	}

}
