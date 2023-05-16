package org.generation.ecommerce.controller;

import java.util.List;

import org.generation.ecommerce.model.ChangePassword;
import org.generation.ecommerce.model.Usuario;
import org.generation.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "api/usuarios/")

public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController (UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}//constructor
	
	@GetMapping
	public List<Usuario> getUsuario(){
		return usuarioService.getAllUsuarios();
	}//getUsuario
	
	@GetMapping (path = "{userId}")
	public Usuario getUsuario (@PathVariable("userId")Long id) {
		return usuarioService.getUsuario(id);
	}//getUsuario
	
	@DeleteMapping (path="{userId}")
	public Usuario deleteUsuario(@PathVariable("userId")Long id) {
		return usuarioService.deleteUsuario(id);
	}//DeleteMapping
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}//addUsuario
	
	@PutMapping (path="{userId}")
	public Usuario updateUsuario(@PathVariable("userId")Long id,
								 @RequestBody ChangePassword changePassword) {
			System.out.println(id);
			System.out.println(changePassword);
		return usuarioService.updateUsuario(id, changePassword);
	}//DeleteMapping

}//UsuarioController
