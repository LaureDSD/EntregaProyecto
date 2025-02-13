package ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.TransaccionesNPC;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.npcRepository.TransaccionesNPCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionesNPCService {
     @Autowired
     private TransaccionesNPCRepository transaccionesNPCRepository;

    public List<TransaccionesNPC> getAll(){
        return  transaccionesNPCRepository.findAll();
    }

    public TransaccionesNPC getByID(Long id){
        return transaccionesNPCRepository.findById(id).orElse(null);
    }

    public TransaccionesNPC setItem(TransaccionesNPC o){
        return  transaccionesNPCRepository.save(o);
    }

    public  void deleteByID(Long id){
        transaccionesNPCRepository.deleteById(id);
    }
}
