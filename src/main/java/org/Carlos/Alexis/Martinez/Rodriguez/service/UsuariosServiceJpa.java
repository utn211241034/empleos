package org.Carlos.Alexis.Martinez.Rodriguez.service;

import java.util.List;
import java.util.Optional;
import org.Carlos.Alexis.Martinez.Rodriguez.model.Usuario;
import org.Carlos.Alexis.Martinez.Rodriguez.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class UsuariosServiceJpa implements intUsuarios {	
	@Autowired
	private UsuariosRepository repoUsuarios;

	@Override
	public List<Usuario> obtenerTodas() {
		return repoUsuarios.findAll();
	}

	@Override
	public void guardar(Usuario usuario) {
		repoUsuarios.save(usuario);
	}

	@Override
	public void eliminar(Integer idUsuario) {
		repoUsuarios.deleteById(idUsuario);
	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		Optional<Usuario> optional = repoUsuarios.findById(idUsuario);
		if ( optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public long numeroUsuarios() {
		// TODO Auto-generated method stub
		return repoUsuarios.count();
	}

	@Override
	public Page<Usuario> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoUsuarios.findAll(page);
	}
}

