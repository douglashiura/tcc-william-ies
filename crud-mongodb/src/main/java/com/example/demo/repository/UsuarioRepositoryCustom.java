package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

@Repository
public interface UsuarioRepositoryCustom extends MongoRepository<Usuario, String>{
	
	public Usuario pesquisarNome(String nome);
	public List<Usuario> pesquisarIdade(int idade);
}
