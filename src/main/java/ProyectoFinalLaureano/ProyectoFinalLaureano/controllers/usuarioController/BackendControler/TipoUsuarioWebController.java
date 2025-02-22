package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.usuarioController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/tipoUsuario")
public class TipoUsuarioWebController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    // Listado de Tipos de Usuario
    @GetMapping
    public String listar(Model model) {
        try {
            List<TipoUsuario> tiposUsuario = tipoUsuarioService.getAll();
            model.addAttribute("tiposUsuario", tiposUsuario);
            model.addAttribute("tipoUsuario", new TipoUsuario());
            return "admin/tipoUsuario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los tipos de usuario: " + e.getMessage());
            return "admin/tipoUsuario";
        }
    }

    // Formulario para crear o editar Tipo de Usuario
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            TipoUsuario tipoUsuario = (id != null) ? tipoUsuarioService.getByID(id) : new TipoUsuario();
            model.addAttribute("tipoUsuario", tipoUsuario);
            return "admin/tipoUsuario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el tipo de usuario para editar: " + e.getMessage());
            return "admin/tipoUsuario";
        }
    }

    // Guardar Tipo de Usuario (creación o actualización)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("tipoUsuario") TipoUsuario tipoUsuario, Model model) throws IOException {
        try {
            tipoUsuarioService.setItem(tipoUsuario);
            return "redirect:/admin/tipoUsuario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el tipo de usuario: " + e.getMessage());
            return "admin/tipoUsuario";
        }
    }

    // Eliminar Tipo de Usuario
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            tipoUsuarioService.deleteByID(id);
            return "redirect:/admin/tipoUsuario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el tipo de usuario: " + e.getMessage());
            return "admin/tipoUsuario";
        }
    }
}
