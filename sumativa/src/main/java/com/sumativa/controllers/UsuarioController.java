package com.sumativa.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumativa.models.Usuario;
import com.sumativa.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	//dependecia hacia usuarioService y de este a repos
	private final UsuarioService us;
	public UsuarioController(UsuarioService usuarioService) {
		this.us=usuarioService;
	}
	
	
	
	@RequestMapping("")
	public String inicio(@ModelAttribute("usuario") Usuario usuario, Model model) {
		ArrayList<Usuario> listaUsuarios=us.findAll();
		model.addAttribute("listaUsuarios", listaUsuarios);
		return "usuario.jsp";
	}
	
	@RequestMapping(value="/insertar", method=RequestMethod.POST)
	public String insertar(@Valid @ModelAttribute("usuario") Usuario usuario, Model model) {
		System.out.println("insertar"+usuario);
		us.insertarUsuario(usuario);
		return "redirect:/usuario";
	}
	
	 @RequestMapping(value="/eliminar")
	 public String eliminar(@RequestParam("id") Long id) {
		 us.eliminarUsuario(id);
		 return "redirect:/usuario";
	 }
	
	 
	 
	 
	 
	 @RequestMapping(value="/actualizar/{id}", method=RequestMethod.GET)
	 public String actualizar(@PathVariable("id") Long id, Model model) {
		 System.out.println("Actualizar id: "+id);
		 Usuario usuario =us.buscarUsuario(id);
		 
		 model.addAttribute("usuario", usuario);
		 return "editarUsuario.jsp";
	 }
	 
	 
	 @RequestMapping(value="/modificar", method=RequestMethod.PUT)
	 public String modificar(@Valid @ModelAttribute("usuario") Usuario usuario) {
		 
		 System.out.println("el Id a modificar es: "+usuario.getId());
		 us.modificarUsuario(usuario);
		 return "redirect:/usuario";
	 }
	 
	 
	 
	 
	 
	 
	
}
