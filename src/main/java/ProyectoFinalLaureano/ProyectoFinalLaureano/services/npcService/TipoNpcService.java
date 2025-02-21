package ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.npcRepository.TipoNpcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoNpcService {
    @Autowired
    private TipoNpcRepository tipoNPCRepository;

    public List<TipoNPC> getAll(){
        return  tipoNPCRepository.findAll();
    }

    public TipoNPC getByID(Long id){
        return tipoNPCRepository.findById(id).orElse(null);
    }

    public TipoNPC setItem(TipoNPC o){
        return  tipoNPCRepository.save(o);
    }

    public  void deleteByID(Long id){
        tipoNPCRepository.deleteById(id);
    }

}
