package ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.TipoMapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.mapaRepository.MapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapaService {
    @Autowired
    private MapaRepository mapaRepository;

    public List<Mapa> getAll(){
        return  mapaRepository.findAll();
    }

    public Mapa getByID(Long id){
        return mapaRepository.findById(id).orElse(null);
    }

    public Mapa setItem(Mapa o){
        return  mapaRepository.save(o);
    }

    public  void deleteByID(Long id){
        mapaRepository.deleteById(id);
    }

    public List<Mapa> getBytipoMapa(TipoMapa tipoMapa) {
        return mapaRepository.getBytipoMapa(tipoMapa);
    }
}
