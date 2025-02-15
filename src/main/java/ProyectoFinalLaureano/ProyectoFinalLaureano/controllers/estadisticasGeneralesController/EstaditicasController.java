package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.estadisticasGeneralesController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.services.estadisticasService.EstadisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estadisticas")
public class EstaditicasController {

    @Autowired
    private EstadisticasService estadisticasService;


}
