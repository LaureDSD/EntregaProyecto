package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/mapas")
public class MapaWebController {

    @Autowired
    private MapaService service;

    // Listado de Mapas
    @GetMapping
    public String listar(Model model) {
        try {
            List<Mapa> mapas = service.getAll();
            model.addAttribute("mapas", mapas);
            return "admin/mapas";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los mapas: " + e.getMessage());
            return "admin/mapas";
        }
    }

    // Formulario para crear o editar un Mapa
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            Mapa mapa = (id != null) ? service.getByID(id) : new Mapa();
            model.addAttribute("mapa", mapa);
            return "admin/mapas";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el mapa para editar: " + e.getMessage());
            return "admin/mapas";
        }
    }

    // Guardar un Mapa (creación o actualización)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("mapa") Mapa mapa, Model model) throws IOException {
        try {
            service.setItem(mapa);
            return "redirect:/admin/mapas";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el mapa: " + e.getMessage());
            return "admin/mapas";
        }
    }

    // Eliminar un Mapa
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/mapas";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el mapa: " + e.getMessage());
            return "admin/mapas";
        }
    }
}
