package ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.usuarioRepository.TipoUsuarioRepository;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.usuarioRepository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public List<Usuario> getAll(){
        return  usuarioRepository.findAll();
    }

    public Usuario getByID(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario setItem(Usuario o){
        o.setContraseña(new BCryptPasswordEncoder().encode(o.getContraseña()));
        return  usuarioRepository.save(o);
    }

    public  void deleteByID(Long id){
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> getByTipoUsuarioID(TipoUsuario tu) {
        return usuarioRepository.getByTipoUsuario(tu);
    }
}
