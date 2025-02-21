package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.logController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersonajeMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogPersonajeMonstruoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/logJugador")
public class LogPersonajeWebController {

    @Autowired
    private LogPersonajeMonstruoService service;

    @GetMapping
    public String listar(Model model) {
        try {
            List<LogPersonajeMonstruo> logJugador = service.getAll();
            model.addAttribute("logJugador", logJugador);
            model.addAttribute("log", new LogPersonajeMonstruo());
            return "admin/logJugador";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los logs: " + e.getMessage());
            return "admin/logJugador";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            LogPersonajeMonstruo logJugador = (id != null) ? service.getByID(id) : new LogPersonajeMonstruo();
            model.addAttribute("logJugador", logJugador);
            return "admin/logJugador";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el log para editar: " + e.getMessage());
            return "admin/logJugador";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("logJugador") LogPersonajeMonstruo logJugador, Model model) throws IOException {
        try {
            service.setItem(logJugador);
            return "redirect:/admin/logJugador";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el log: " + e.getMessage());
            return "admin/logJugador";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/logJugador";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el log: " + e.getMessage());
            return "admin/logJugador";
        }
    }
}
