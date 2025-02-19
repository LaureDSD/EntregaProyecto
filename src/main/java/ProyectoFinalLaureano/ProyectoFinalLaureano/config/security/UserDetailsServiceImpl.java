package ProyectoFinalLaureano.ProyectoFinalLaureano.config.security;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.usuarioRepository.TipoUsuarioRepository;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.usuarioRepository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreo(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + email);
        }

        //Indica la referecia de autoridad del tipo usuario, en este caso el id de la tabla.
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getTipoUsuario().toString());

        return User.builder()
                .username(usuario.getCorreo())
                .password(usuario.getContraseña())
                .authorities(Collections.singletonList(authority))
                .build();
    }
}