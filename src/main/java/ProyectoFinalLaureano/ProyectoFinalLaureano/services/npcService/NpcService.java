package ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.Npc;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.npcRepository.NpcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NpcService {
    @Autowired
    private NpcRepository npcRepository;

    public List<Npc> getAll(){
        return  npcRepository.findAll();
    }

    public Npc getByID(Long id){
        return npcRepository.findById(id).orElse(null);
    }

    public Npc setItem(Npc o){
        return  npcRepository.save(o);
    }

    public  void deleteByID(Long id){
        npcRepository.deleteById(id);
    }

    public List<Npc> getBytipoNPC(TipoNPC tipoNPC) {
        return npcRepository.getBytipoNPC(tipoNPC);
    }
}
