package com.solak.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solak.cursomc.domain.Categoria;
import com.solak.cursomc.repositories.CategoriaRepository;
import com.solak.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired      
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID:" +id
					+ ", Tipo: " + Categoria.class.getName());
		}
		return obj;
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);  //id deve ser nulo
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
}
