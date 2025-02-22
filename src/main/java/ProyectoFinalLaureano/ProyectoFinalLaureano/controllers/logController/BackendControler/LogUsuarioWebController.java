package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.logController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogUsuarioService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/log/logUsuarios")
public class LogUsuarioWebController {

    private final String rutaHTML = "/admin/log/logUsuarios";

    @Autowired
    private LogUsuarioService service;

    @Autowired
    private UsuarioService usuarioService;

    private List<Usuario> ul;

    @GetMapping
    public String listar(Model model) {
        try {
            ul = usuarioService.getAll();
            List<LogUsuario> logUsuarios = service.getAll();
            model.addAttribute("logUsuarios", logUsuarios);
            model.addAttribute("logUsuario", new LogUsuario());
            model.addAttribute("usuarioList", ul);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los logs de usuarios: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            LogUsuario logUsuario = (id != null) ? service.getByID(id) : new LogUsuario();
            model.addAttribute("logUsuario", logUsuario);
            model.addAttribute("listaUsuarios", ul);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el log de usuario para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("logUsuario") LogUsuario logUsuario, Model model) throws IOException {
        try {
            logUsuario.setFechaLog(new Date());
            service.setItem(logUsuario);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el log de usuario: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el log de usuario: " + e.getMessage());
            return rutaHTML;
        }
    }
}
