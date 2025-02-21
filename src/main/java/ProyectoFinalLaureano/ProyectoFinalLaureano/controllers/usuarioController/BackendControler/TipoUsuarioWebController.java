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

    // Listado de  de Personaje
    @GetMapping
    public String listarPersonaje(Model model) {
        List<TipoUsuario> o = tipoUsuarioService.getAll();
        model.addAttribute("tiposUsuario", o);
        return "admin/tipoUsuario";
    }

    // Formulario para crear o editar  de Personaje
    @GetMapping("/edit/{id}")
    public String editarPersonaje(@PathVariable("id") Long id, Model model) {
        TipoUsuario o = (id != null) ? tipoUsuarioService.getByID(id) : new TipoUsuario();
        model.addAttribute("tiposUsuario", o);
        return "admin/tipoUsuario";
    }

    // Guardar  de Personaje (creación o actualización)
    @PostMapping("/save")
    public String guardarPersonaje(@ModelAttribute("tipoUsuario") TipoUsuario o) throws IOException {
        tipoUsuarioService.setItem(o);
        return "admin/tipoUsuario";
    }

    // Eliminar  de Personaje
    @GetMapping("/delete/{id}")
    public String eliminarPersonaje(@PathVariable("id") Long id) {
        try {
            tipoUsuarioService.deleteByID(id);
            return "redirect:/admin/tipoUsuario";
        }catch (Exception e){
            return "redirect:/admin/tipoUsuario";
        }
    }


}
