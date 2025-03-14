package ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.mapaRepository.MapaEfectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapaEfectoService {
    @Autowired
    private MapaEfectoRepository mapaEfectoRepository;

    public List<MapaEfecto> getAll(){
        return  mapaEfectoRepository.findAll();
    }

    public MapaEfecto getByID(Long id){
        return mapaEfectoRepository.findById(id).orElse(null);
    }

    public MapaEfecto setItem(MapaEfecto o){
        return  mapaEfectoRepository.save(o);
    }

    public  void deleteByID(Long id){
        mapaEfectoRepository.deleteById(id);
    }

}
