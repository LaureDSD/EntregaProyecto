package ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.mapaRepository.MapaMonstruoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapaMonstruoService {

    @Autowired
    private MapaMonstruoRepository monstruoRepository;

    public List<MapaMonstruo> getAll(){
        return  monstruoRepository.findAll();
    }

    public MapaMonstruo getByID(Long id){
        return monstruoRepository.findById(id).orElse(null);
    }

    public MapaMonstruo setItem(MapaMonstruo o){
        return  monstruoRepository.save(o);
    }

    public  void deleteByID(Long id){
        monstruoRepository.deleteById(id);
    }

}
