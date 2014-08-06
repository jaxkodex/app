package org.educando.app.service.Impl;

import java.util.List;

import org.educando.app.model.Usuario;
import org.educando.app.repository.UsuarioRepository;
import org.educando.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
	@Autowired UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario create (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario load(String username) {
		return usuarioRepository.findOne(username);
	}

	@Override
	public void delete(String id) {
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findOne(username);
		if (usuario == null) throw new UsernameNotFoundException("Usuario/Contraseña incorrectos");
		return usuario;
	}

}
