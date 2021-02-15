package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepositoryCustom;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositoryCustom repository;
	
	public Usuario cadastrar(String nome, String sobrenome, int idade) {
		return repository.save(new Usuario(nome, sobrenome, idade));
	}
	
	public List<Usuario> listarTodos(){
		return repository.findAll();
	}
	
	public Usuario pesquisarNome(String nome) {
		return repository.pesquisarNome(nome);
	}
	
	public Usuario atualizar(String nome, String sobrenome, int idade) {
		Usuario user = repository.pesquisarNome(nome);
		user.setSobrenome(sobrenome);
		user.setIdade(idade);
		return repository.save(user);
	}
	
	public void deletarTodos() {
		repository.deleteAll();
	}
	
	public void deletar(String nome) {
		Usuario user = repository.pesquisarNome(nome);
		repository.delete(user);
	}
}
