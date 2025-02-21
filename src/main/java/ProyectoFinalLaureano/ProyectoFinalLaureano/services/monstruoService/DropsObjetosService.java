package ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.DropsObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.monstruoRepository.DropsObjetosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DropsObjetosService {
    @Autowired
    private DropsObjetosRepository dropsObjetosRepository;

    public List<DropsObjetos> getAll(){
        return  dropsObjetosRepository.findAll();
    }

    public DropsObjetos getByID(Long id){
        return dropsObjetosRepository.findById(id).orElse(null);
    }

    public DropsObjetos setItem(DropsObjetos o){
        return  dropsObjetosRepository.save(o);
    }

    public  void deleteByID(Long id){
        dropsObjetosRepository.deleteById(id);
    }
}
