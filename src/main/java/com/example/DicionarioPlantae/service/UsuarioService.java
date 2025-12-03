package com.example.DicionarioPlantae.service;



import com.example.DicionarioPlantae.dto.request.UserDTORequest;
import com.example.DicionarioPlantae.dto.response.UserDTOResponse;
import com.example.DicionarioPlantae.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private ModelMapper modelMapper;

  public List<Usuario> listarUsuario() {
    return usuarioRepository.findAll();
  }

  public Usuario listarUsuarioPorId(Integer idUsuario) {
    return usuarioRepository.findById(Long.valueOf(idUsuario)).orElse(null);
  }

  public UsuarioDTOResponse salvar(UsuarioDTORequest usuarioDTORequest) {
    Usuario usuario = modelMapper.map(usuarioDTORequest, Usuario.class);
    Usuario savedUsuario = usuarioRepository.save(usuario);
    return modelMapper.map(savedUsuario, UsuarioDTOResponse.class);
  }

  public UsuarioDTOResponse atualizar(Integer idUsuario, UsuarioDTORequest usuarioDTORequest) {
    Usuario usuario = usuarioRepository.findById(Long.valueOf(idUsuario)).orElseThrow(() -> new RuntimeException("User not found"));
    modelMapper.map(usuarioDTORequest, usuario);
    Usuario updatedUsuario = usuarioRepository.save(usuario);
    return modelMapper.map(updatedUsuario, UsuarioDTOResponse.class);
  }

  public void apagar(Integer idUser) {
    usuarioRepository.deleteById(Long.valueOf(idUsuario));
  }
}

