package ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NpcItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.npcRepository.NpcItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NpcItemService {
    @Autowired
    private NpcItemRepository tiendaNPCRepository;

    public List<NpcItem> getAll(){
        return  tiendaNPCRepository.findAll();
    }

    public NpcItem getByID(Long id){
        return tiendaNPCRepository.findById(id).orElse(null);
    }

    public NpcItem setItem(NpcItem o){
        return  tiendaNPCRepository.save(o);
    }

    public  void deleteByID(Long id){
        tiendaNPCRepository.deleteById(id);
    }

}
