package ProyectoFinalLaureano.ProyectoFinalLaureano.services.estadisticasService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.estadisticasRepository.EstadisticasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticasService {

    @Autowired
    private EstadisticasRepository estadisticasRepository;

    public List<EstadisticasGenerales> getAll(){
        return  estadisticasRepository.findAll();
    }

    public EstadisticasGenerales getByID(Long id){
        return estadisticasRepository.findById(id).orElse(null);
    }

    public EstadisticasGenerales setItem(EstadisticasGenerales o){
        return  estadisticasRepository.save(o);
    }

    public  void deleteByID(Long id){
        estadisticasRepository.deleteById(id);
    }

}
