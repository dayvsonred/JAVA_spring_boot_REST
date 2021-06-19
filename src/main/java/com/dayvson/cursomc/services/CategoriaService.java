package com.dayvson.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayvson.cursomc.domain.Categoria;
import com.dayvson.cursomc.repositories.CategoriaRepository;
import com.dayvson.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria  buscar(Integer Id) {
		Optional<Categoria> obj = repo.findById(Id); 
		return obj.orElse(null); 
	}
	
	public Categoria find(Integer id) {  
		Optional<Categoria> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException(  "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); 
	}

}
