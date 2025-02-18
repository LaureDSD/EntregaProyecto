package ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.inventario.InventarioPersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.inventario.InventarioPersonajeId;
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

    public InventarioPersonaje getByID(InventarioPersonajeId id){
        return inventarioPersonajeRepository.findById(id).orElse(null);
    }

    public InventarioPersonaje setItem(InventarioPersonaje o){
        return  inventarioPersonajeRepository.save(o);
    }

    public  void deleteByID(InventarioPersonajeId id){
        inventarioPersonajeRepository.deleteById(id);
    }

    public List<InventarioPersonaje> getByPersonajeId(Long personajeId) {
        return inventarioPersonajeRepository.getByPersonajeId(personajeId);
    }
}
