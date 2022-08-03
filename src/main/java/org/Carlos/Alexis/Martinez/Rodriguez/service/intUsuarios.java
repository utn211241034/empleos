package org.Carlos.Alexis.Martinez.Rodriguez.service;

import java.util.List;
import org.Carlos.Alexis.Martinez.Rodriguez.model.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface intUsuarios {

	public List<Usuario> obtenerTodas();
	public void guardar(Usuario usuario);
	public void eliminar(Integer idUsuario);
	public Usuario buscarPorId(Integer idUsuario);
	public long numeroUsuarios();
	
	public Page<Usuario>buscarTodas(Pageable page);
}

