package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.logController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersonajeMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogPersonajeMonstruoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruosService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/log/logJugadores")
public class LogPersonajeWebController {

    private final String rutaHTML ="/admin/log/logJugadores";

    @Autowired
    private LogPersonajeMonstruoService service;

    @Autowired
    private PersoanjeService persoanjeService;

    @Autowired
    private MonstruosService monstruosService;


    private List<Personaje> pl;
    private List<Monstruo> ml;

    @GetMapping
    public String listar(Model model) {
        try {
             pl = persoanjeService.getAll();
            ml = monstruosService.getAll();
            List<LogPersonajeMonstruo> logJugador = service.getAll();
            model.addAttribute("logJugadores", logJugador);
            model.addAttribute("logJugador", new LogPersonajeMonstruo());
            model.addAttribute("personajeList", pl );
            model.addAttribute("monstruoList", ml );
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los logs: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            LogPersonajeMonstruo logJugador = (id != null) ? service.getByID(id) : new LogPersonajeMonstruo();
            model.addAttribute("logJugador", logJugador);
            model.addAttribute("personajeList", pl );
            model.addAttribute("monstruoList", ml );
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el log para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("logJugador") LogPersonajeMonstruo logJugador, Model model) throws IOException {
        try {
            logJugador.setFechaCaza(new Date());
            service.setItem(logJugador);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el log: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el log: " + e.getMessage());
            return rutaHTML;
        }
    }
}
