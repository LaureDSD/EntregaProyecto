package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.usuarioController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.TipoUsuarioService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuarioWebController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoUsuarioService tipoUsuarioService;



    // Endpoint para mostrar la lista de usuarios
    @GetMapping
    public String showUsuariosList(Model model) {
        try {
            try{}catch (Exception e){throw  e;}

            List<Usuario> usuarios = usuarioService.getAll();
            model.addAttribute("usuarios", usuarios);
            return "admin/usuarios";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los usuarios: " + e.getMessage());
            return "admin/usuarios";
        }
    }

    // Formulario para crear o editar un usuario
    @GetMapping("/edit/{id}")
    public String editarUsuario(@PathVariable("id") Long id, Model model) {
        try {
            Usuario usuario = (id != null) ? usuarioService.getByID(id) : new Usuario();
            model.addAttribute("usuario", usuario);
            return "admin/usuarios";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el usuario para editar: " + e.getMessage());
            return "admin/usuarios";
        }
    }

    // Guardar un usuario (creación o actualización)
    @PostMapping("/save")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) throws IOException {
        try {
            usuarioService.setItem(usuario);
            return "redirect:/admin/usuarios";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el usuario: " + e.getMessage());
            return "admin/usuarios";
        }
    }

    // Endpoint para eliminar un usuario
    @GetMapping("/delete/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id, Model model) {
        try {
            usuarioService.deleteByID(id);
            return "redirect:/admin/usuarios";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el usuario: " + e.getMessage());
            return "admin/usuarios";
        }
    }
}
