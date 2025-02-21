package ProyectoFinalLaureano.ProyectoFinalLaureano.services.habilidadService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.habilidad.HabilidadEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.habilidadRepository.HabilidadEfectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabildadEfectoService {
    @Autowired
    private HabilidadEfectoRepository habilidadEfectoRepository;

    public List<HabilidadEfecto> getAll(){
        return  habilidadEfectoRepository.findAll();
    }

    public HabilidadEfecto getByID(Long id){
        return habilidadEfectoRepository.findById(id).orElse(null);
    }

    public HabilidadEfecto setItem(HabilidadEfecto o){
        return  habilidadEfectoRepository.save(o);
    }

    public  void deleteByID(Long id){
        habilidadEfectoRepository.deleteById(id);
    }

}
