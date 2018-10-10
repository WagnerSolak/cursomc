package com.solak.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")  //endpoint
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET) //requisicao para obter dados
	public String listar() {
		return "REST está funcionando!";
	}
}
