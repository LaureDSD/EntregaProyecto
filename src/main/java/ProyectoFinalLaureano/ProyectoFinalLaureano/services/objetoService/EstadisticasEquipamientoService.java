package ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.EstadisticasEquipamiento;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.objetoRepository.EstadisticaEquipamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticasEquipamientoService {
    @Autowired
    private EstadisticaEquipamientoRepository estadisticaEquipamientoRepository;

    public List<EstadisticasEquipamiento> getAll(){
        return  estadisticaEquipamientoRepository.findAll();
    }

    public EstadisticasEquipamiento getByID(Long id){
        return estadisticaEquipamientoRepository.findById(id).orElse(null);
    }

    public EstadisticasEquipamiento setItem(EstadisticasEquipamiento o){
        return  estadisticaEquipamientoRepository.save(o);
    }

    public  void deleteByID(Long id){
        estadisticaEquipamientoRepository.deleteById(id);
    }
}
