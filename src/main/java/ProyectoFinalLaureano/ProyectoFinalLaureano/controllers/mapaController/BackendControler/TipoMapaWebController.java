package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.TipoMapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.TipoMapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/mapa/tipoMapa")
public class TipoMapaWebController {

    private final String rutaHTML ="/admin/mapa/tipoMapa";

    @Autowired
    private TipoMapaService service;

    // Listado de Tipos de Mapa
    @GetMapping
    public String listar(Model model) {
        try {
            List<TipoMapa> tiposMapa = service.getAll();
            model.addAttribute("tiposMapa", tiposMapa);
            model.addAttribute("tipoMapa", new TipoMapa());
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los tipos de mapa: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Formulario para crear o editar un Tipo de Mapa
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            TipoMapa tipoMapa = (id != null) ? service.getByID(id) : new TipoMapa();
            model.addAttribute("tipoMapa", tipoMapa);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el tipo de mapa para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Guardar un Tipo de Mapa (creación o actualización)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("tipoMapa") TipoMapa tipoMapa, Model model) throws IOException {
        try {
            service.setItem(tipoMapa);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el tipo de mapa: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Eliminar un Tipo de Mapa
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el tipo de mapa: " + e.getMessage());
            return rutaHTML;
        }
    }
}
