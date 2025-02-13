package ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.usuarioRepository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll(){
        return  usuarioRepository.findAll();
    }

    public Usuario getByID(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario setItem(Usuario o){
        return  usuarioRepository.save(o);
    }

    public  void deleteByID(Long id){
        usuarioRepository.deleteById(id);
    }


}
