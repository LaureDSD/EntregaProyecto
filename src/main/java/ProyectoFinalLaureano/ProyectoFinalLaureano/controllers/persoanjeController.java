package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.EstadisticasPersonajeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.InventarioPersonajeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.RegistroPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pesonaje")
public class persoanjeController {

    @Autowired
    private PersoanjeService persoanjeService;

    @Autowired
    private RegistroPersonajeService registroPersoanjeService;

    @Autowired
    private EstadisticasPersonajeService estadisticasPersonajesService;

    @Autowired
    private InventarioPersonajeService inventarioPersonajeService;

    @GetMapping("/")
    public List<Personaje> obtenerUsuario(){
        return  persoanjeService.getAll();
    }

}
