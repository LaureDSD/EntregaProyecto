package ProyectoFinalLaureano.ProyectoFinalLaureano.services.efectoEstadoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.efectosEstadosRepository.EfectoEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EfectoEstadoService {
    @Autowired
    private EfectoEstadoRepository efectoEstadoRepository;

    public List<EfectoEstado> getAll(){
        return  efectoEstadoRepository.findAll();
    }

    public EfectoEstado getByID(Long id){
        return efectoEstadoRepository.findById(id).orElse(null);
    }

    public EfectoEstado setItem(EfectoEstado o){
        return  efectoEstadoRepository.save(o);
    }

    public  void deleteByID(Long id){
        efectoEstadoRepository.deleteById(id);
    }
}
