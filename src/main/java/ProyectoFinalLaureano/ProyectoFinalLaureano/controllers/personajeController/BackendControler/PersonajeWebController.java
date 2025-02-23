package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.personajeController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos.Grupo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.Npc;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.ClasePersonaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.estadisticasService.EstadisticasService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.grupoService.GrupoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.ClasePersonajeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/personaje/personajes")
public class PersonajeWebController {

    private final String rutaHTML = "/admin/personaje/personajes";

    @Autowired
    private PersoanjeService personajeService;

    @Autowired
    private ClasePersonajeService clasePersonajeService;
    private List<ClasePersonaje> cpl;

    @Autowired
    private GrupoService grupoService;
    private List<Grupo> gl;

    @Autowired
    private UsuarioService usuarioService;
    private List<Usuario> ul;

    // Listado de Personajes
    @GetMapping
    public String listarPersonaje(Model model) {
        try {
            gl = grupoService.getAll();
            cpl =clasePersonajeService.getAll();
            ul = usuarioService.getAll();
            List<Personaje> personaje = personajeService.getAll();
            model.addAttribute("personajes", personaje);
            model.addAttribute("personaje", new Personaje());
            model.addAttribute("grupoList", gl);
            model.addAttribute("clasePersonajeList", cpl);
            model.addAttribute("usuarioList", ul);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los personajes: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Formulario para crear o editar Personaje
    @GetMapping("/edit/{id}")
    public String editarPersonaje(@PathVariable("id") Long id, Model model) {
        try {
            Personaje personaje = (id != null) ? personajeService.getByID(id) : new Personaje();
            model.addAttribute("personaje", personaje);
            model.addAttribute("grupoList", gl);
            model.addAttribute("clasePersonajeList", cpl);
            model.addAttribute("usuarioList", ul);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los datos del personaje: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Guardar Personaje (creación o actualización)
    @PostMapping("/save")
    public String guardarPersonaje(@ModelAttribute("personaje") Personaje personaje, Model model) throws IOException {
        try {
            personaje.setFecha_creacion(new Date());
            personajeService.setItem(personaje);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el personaje: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Eliminar Personaje
    @GetMapping("/delete/{id}")
    public String eliminarPersonaje(@PathVariable("id") Long id) {
        try {
            personajeService.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            return rutaHTML;
        }
    }
}
