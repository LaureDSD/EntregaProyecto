package ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.equipamiento.TipoEquipamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEquipamientoService {
    @Autowired
    private TipoEquipamientoRepository tipoEquipamientoRepository;

    public List<TipoEquipamiento> getAll(){
        return  tipoEquipamientoRepository.findAll();
    }

    public TipoEquipamiento getByID(Long id){
        return tipoEquipamientoRepository.findById(id).orElse(null);
    }

    public TipoEquipamiento setItem(TipoEquipamiento o){
        return  tipoEquipamientoRepository.save(o);
    }

    public  void deleteByID(Long id){
        tipoEquipamientoRepository.deleteById(id);
    }
}
