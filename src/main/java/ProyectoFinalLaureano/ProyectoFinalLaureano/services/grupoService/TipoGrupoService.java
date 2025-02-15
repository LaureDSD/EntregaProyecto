package ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.TipoGrupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.grupoRepository.TipoGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoGrupoService {
    @Autowired
    private TipoGrupoRepository tipoGrupoRepository;

    public List<TipoGrupo> getAll(){
        return  tipoGrupoRepository.findAll();
    }

    public TipoGrupo getByID(Long id){
        return tipoGrupoRepository.findById(id).orElse(null);
    }

    public TipoGrupo setItem(TipoGrupo o){
        return  tipoGrupoRepository.save(o);
    }

    public  void deleteByID(Long id){
        tipoGrupoRepository.deleteById(id);
    }
}
