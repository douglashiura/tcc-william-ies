package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestParam String nome, @RequestParam String sobrenome, @RequestParam int idade) {
		Usuario user = service.cadastrar(nome, sobrenome, idade);
		return user.toString();
	}
	
	@RequestMapping("/pesquisar")
	public Usuario pesquisarUsuario(@RequestParam String nome) {
		return service.pesquisarNome(nome);
	}
	
	@RequestMapping("/listar")
	public List<Usuario> listarTudo(){
		return service.listarTodos();
	}
	
	@RequestMapping("/atualizar")
	public String atualizar(@RequestParam String nome, @RequestParam String sobrenome, @RequestParam int idade) {
		Usuario user = service.atualizar(nome, sobrenome, idade);
		return user.toString();
	}
	
	@RequestMapping("/remover")
	public String remover(@RequestParam String nome) {
		service.deletar(nome);
		return "Usuario removido: " + nome;
	}
	
	@RequestMapping("/removerTudo")
	public String removerTudo() {
		service.deletarTodos();
		return "Todos os registros foram removidos";
	}
}
