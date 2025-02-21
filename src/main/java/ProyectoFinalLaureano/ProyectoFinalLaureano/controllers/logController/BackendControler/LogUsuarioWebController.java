package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.logController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/logUsuarios")
public class LogUsuarioWebController {

    @Autowired
    private LogUsuarioService service;

    @GetMapping
    public String listar(Model model) {
        try {
            List<LogUsuario> logUsuarios = service.getAll();
            model.addAttribute("logUsuarios", logUsuarios);
            model.addAttribute("logUsuario", new LogUsuario());
            return "admin/logUsuario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los logs de usuarios: " + e.getMessage());
            return "admin/logUsuario";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            LogUsuario logUsuario = (id != null) ? service.getByID(id) : new LogUsuario();
            model.addAttribute("logUsuarios", logUsuario);
            return "admin/logUsuario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el log de usuario para editar: " + e.getMessage());
            return "admin/logUsuario";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("logUsuarios") LogUsuario logUsuario, Model model) throws IOException {
        try {
            service.setItem(logUsuario);
            return "redirect:/admin/logUsuarios";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el log de usuario: " + e.getMessage());
            return "admin/logUsuario";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/logUsuarios";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el log de usuario: " + e.getMessage());
            return "admin/logUsuario";
        }
    }
}
