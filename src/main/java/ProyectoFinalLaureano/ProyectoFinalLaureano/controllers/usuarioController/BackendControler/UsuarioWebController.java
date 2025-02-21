package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.usuarioController.BackendControler;


import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
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

    // Endpoint para mostrar la lista de usuarios
    @GetMapping
    public String showUsuariosList(Model model) {
        List<Usuario> usuario = usuarioService.getAll();
        model.addAttribute("usuarios", usuario);
        return "admin/usuarios";
    }

    // Formulario para crear o editar  de Personaje
    @GetMapping("/edit/{id}")
    public String editarPersonaje(@PathVariable("id") Long id, Model model) {
        Usuario usuario = (id != null) ? usuarioService.getByID(id) : new Usuario();
        model.addAttribute("usuario", usuario);
        return "admin/usuarios";
    }


    // Guardar  de Personaje (creación o actualización)
    @PostMapping("/save")
    public String guardarPersonaje(@ModelAttribute("usuarios") Usuario u) throws IOException {
        usuarioService.setItem(u);
        return "admin/usuarios";
    }

    // Endpoint para eliminar un usuario
    @GetMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable("id") Long id) {
        try {
            usuarioService.deleteByID(id);
            return "admin/usuarios";
        }catch (Exception e){
            return "admin/usuarios";
        }
    }
}
