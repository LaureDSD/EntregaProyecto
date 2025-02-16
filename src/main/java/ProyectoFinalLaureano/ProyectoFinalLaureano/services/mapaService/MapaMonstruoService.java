package ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.monstruos.MapaMonstruoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.TipoMonstruo;
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

    public MapaMonstruo getByID(MapaMonstruoId id){
        return monstruoRepository.findById(id).orElse(null);
    }

    public MapaMonstruo setItem(MapaMonstruo o){
        return  monstruoRepository.save(o);
    }

    public  void deleteByID(MapaMonstruoId id){
        monstruoRepository.deleteById(id);
    }

}
