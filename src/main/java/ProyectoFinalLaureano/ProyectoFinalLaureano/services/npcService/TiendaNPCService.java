package ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.NPCProducto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.npcRepository.TiendaNPCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaNPCService {
    @Autowired
    private TiendaNPCRepository tiendaNPCRepository;

    public List<NPCProducto> getAll(){
        return  tiendaNPCRepository.findAll();
    }

    public NPCProducto getByID(Long id){
        return tiendaNPCRepository.findById(id).orElse(null);
    }

    public NPCProducto setItem(NPCProducto o){
        return  tiendaNPCRepository.save(o);
    }

    public  void deleteByID(Long id){
        tiendaNPCRepository.deleteById(id);
    }

}
