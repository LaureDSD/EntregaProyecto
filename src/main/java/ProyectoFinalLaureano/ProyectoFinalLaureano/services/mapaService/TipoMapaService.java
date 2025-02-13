package ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.TipoMapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.mapaRepository.TipoMapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMapaService {
    @Autowired
    private TipoMapaRepository tipoMapaRepository;

    public List<TipoMapa> getAll(){
        return  tipoMapaRepository.findAll();
    }

    public TipoMapa getByID(Long id){
        return tipoMapaRepository.findById(id).orElse(null);
    }

    public TipoMapa setItem(TipoMapa o){
        return  tipoMapaRepository.save(o);
    }

    public  void deleteByID(Long id){
        tipoMapaRepository.deleteById(id);
    }
}
