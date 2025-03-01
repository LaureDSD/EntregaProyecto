package ProyectoFinalLaureano.ProyectoFinalLaureano.config.security;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.usuarioRepository.TipoUsuarioRepository;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.usuarioRepository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optionalUsuario = Optional.ofNullable(usuarioRepository.findByCorreo(username));
        if (optionalUsuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        Usuario usuario = optionalUsuario.get();
        GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getTipoUsuario().getNombre());
        return new org.springframework.security.core.userdetails.User(
                usuario.getCorreo(), usuario.getContraseña(), List.of(authority));
    }
}
