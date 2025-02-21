package ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.MonstruoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.monstruoRepository.MonstruoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonstruoItemService {
    @Autowired
    private MonstruoItemRepository dropsObjetosRepository;

    public List<MonstruoItem> getAll(){
        return  dropsObjetosRepository.findAll();
    }

    public MonstruoItem getByID(Long id){
        return dropsObjetosRepository.findById(id).orElse(null);
    }

    public MonstruoItem setItem(MonstruoItem o){
        return  dropsObjetosRepository.save(o);
    }

    public  void deleteByID(Long id){
        dropsObjetosRepository.deleteById(id);
    }
}
