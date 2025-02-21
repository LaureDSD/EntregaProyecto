package ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.InventarioPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.personajeRepository.InventarioPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioPersonajeService {

    @Autowired
    InventarioPersonajeRepository inventarioPersonajeRepository;

    public List<InventarioPersonaje> getAll(){
        return  inventarioPersonajeRepository.findAll();
    }

    public InventarioPersonaje getByID(Long id){
        return inventarioPersonajeRepository.findById(id).orElse(null);
    }

    public InventarioPersonaje setItem(InventarioPersonaje o){
        return  inventarioPersonajeRepository.save(o);
    }

    public  void deleteByID(Long id){
        inventarioPersonajeRepository.deleteById(id);
    }

}
