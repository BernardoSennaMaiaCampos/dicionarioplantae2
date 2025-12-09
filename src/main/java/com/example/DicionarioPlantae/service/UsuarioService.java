package com.example.DicionarioPlantae.service;

import com.example.DicionarioPlantae.config.SecurityConfiguration;
import com.example.DicionarioPlantae.dto.request.UsuarioRequest;
import com.example.DicionarioPlantae.dto.response.UsuarioLoginDTOResponse;
import com.example.DicionarioPlantae.dto.response.UsuarioResponse;
import com.example.DicionarioPlantae.dto.roles.LoginUserDto;
import com.example.DicionarioPlantae.dto.roles.RecoveryJwtTokenDto;
import com.example.DicionarioPlantae.entity.Roles.Role;
import com.example.DicionarioPlantae.entity.Usuario;
import com.example.DicionarioPlantae.repository.RoleRepository;
import com.example.DicionarioPlantae.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenService jwtTokenService;
    private final UsuarioRepository usuarioRepository;

    private final RoleRepository roleRepository;
    @Autowired
    private SecurityConfiguration securityConfiguration;

    private ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper, RoleRepository roleRepository) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest) {
        Role role = new Role();
        role = roleRepository.findByName(usuarioRequest.getRole());

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(securityConfiguration.passwordEncoder().encode(usuarioRequest.getSenha()));
        usuario.setStatus(usuarioRequest.getStatus());
        usuario.setRoles(List.of(role));

        Usuario usuarioSalvo = this.usuarioRepository.save(usuario);

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setId(usuarioSalvo.getId());
        usuarioResponse.setNome(usuarioSalvo.getNome());
        usuarioResponse.setEmail(usuarioSalvo.getEmail());
        usuarioResponse.setSenha(usuarioSalvo.getSenha());
        usuarioResponse.setStatus(usuarioSalvo.getStatus());

        return usuarioResponse;
    }

    public List<Usuario> listarUsuarios() {
        return this.usuarioRepository.ListarUsuario();
    }

    public Usuario listarUsuarioPorId(int idUsuario) {
        return this.usuarioRepository.obterUsuarioPorId(idUsuario);
    }

    public UsuarioResponse salvarUsuario(UsuarioRequest usuarioRequest) {
        Role role = new Role();
        role = roleRepository.findByName(usuarioRequest.getRole());

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(securityConfiguration.passwordEncoder().encode(usuarioRequest.getSenha()));
        usuario.setStatus(1);
        usuario.setRoles(List.of(role));

        Usuario usuarioSave = this.usuarioRepository.save(usuario);

        return modelMapper.map(usuarioSave, UsuarioResponse.class);
    }

    public UsuarioResponse atualizarUsuario(@Valid Integer usuarioId, UsuarioRequest usuarioRequest) {
        Usuario usuario = this.usuarioRepository.obterUsuarioPorId(usuarioId);
        if (usuario != null) {
            modelMapper.map(usuarioRequest, usuario);
            Usuario usuarioSalvo = this.usuarioRepository.save(usuario);
            return modelMapper.map(usuarioSalvo, UsuarioResponse.class);
        } else {
            return null;
        }
    }

    public void apagarUsuario(Integer usuarioId) {

        this.usuarioRepository.apagarUsuario(usuarioId);
    }

    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                loginUserDto.email(), loginUserDto.password());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Usuario usuario = usuarioRepository.findByEmail(loginUserDto.email()).orElse(null);
        UsuarioLoginDTOResponse usuarioLogin = new UsuarioLoginDTOResponse();
        usuarioLogin.setId(usuario.getId());
        usuarioLogin.setNome(usuario.getNome());
        usuarioLogin.setEmail(usuario.getEmail());
        usuarioLogin.setStatus(usuario.getStatus());

        // Gera um token JWT para o usuário autenticado
        return new RecoveryJwtTokenDto(usuarioLogin, jwtTokenService.generateToken(userDetails));
    }

}
