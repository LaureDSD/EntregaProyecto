package ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TipoNPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.npcRepository.NPCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NPCService {
    @Autowired
    private NPCRepository npcRepository;

    public List<NPC> getAll(){
        return  npcRepository.findAll();
    }

    public NPC getByID(Long id){
        return npcRepository.findById(id).orElse(null);
    }

    public NPC setItem(NPC o){
        return  npcRepository.save(o);
    }

    public  void deleteByID(Long id){
        npcRepository.deleteById(id);
    }

    public List<NPC> getBytipoNPC(TipoNPC tipoNPC) {
        return npcRepository.getBytipoNPC(tipoNPC);
    }
}
