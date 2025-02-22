package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.usuarioController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.TipoUsuario;
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
@RequestMapping("/admin/usuario/usuarios")
public class UsuarioWebController {

    private final String rutaHTML ="/admin/usuario/usuarios";

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    private List<TipoUsuario> tl;

    // Endpoint para mostrar la lista de usuarios
    @GetMapping
    public String showUsuariosList(Model model) {
        try {
            tl = tipoUsuarioService.getAll();
            List<Usuario> usuarios = usuarioService.getAll();
            model.addAttribute("usuarios", usuarios);
            model.addAttribute("usuario", new Usuario());
            model.addAttribute("tipoUsuarioList", tl);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los usuarios: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Formulario para crear o editar un usuario
    @GetMapping("/edit/{id}")
    public String editarUsuario(@PathVariable("id") Long id, Model model) {
        try {
            Usuario usuario = (id != null) ? usuarioService.getByID(id) : new Usuario();
            model.addAttribute("tipoUsuarioList", tl);
            model.addAttribute("usuario", usuario);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el usuario para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Guardar un usuario (creación o actualización)
    @PostMapping("/save")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) throws IOException {
        try {
            usuarioService.setItem(usuario);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el usuario: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Endpoint para eliminar un usuario
    @GetMapping("/delete/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id, Model model) {
        try {
            usuarioService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el usuario: " + e.getMessage());
            return rutaHTML;
        }
    }
}
