package ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.usuarioRepository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public List<TipoUsuario> getAll(){
        return  tipoUsuarioRepository.findAll();
    }

    public TipoUsuario getByID(Long id){
        return tipoUsuarioRepository.findById(id).orElse(null);
    }

    public TipoUsuario setItem(TipoUsuario o){
        return  tipoUsuarioRepository.save(o);
    }

    public  void deleteByID(Long id){
        tipoUsuarioRepository.deleteById(id);
    }
}
