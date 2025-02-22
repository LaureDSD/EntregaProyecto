package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersonajeMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaEfectoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaMonstruoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.TipoMapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/mapasEfecto")
public class MapaEfectoWebController {

    @Autowired
    private MapaEfectoService service;



    @GetMapping
    public String listar(Model model) {
        try {
            List<MapaEfecto> mapasMonstruo = service.getAll();
            model.addAttribute("mapasEfecto", mapasMonstruo);
            model.addAttribute("mapaEfecto", new MapaEfecto());


            return "admin/mapasEfecto";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los efectos de mapa: " + e.getMessage());
            return "admin/mapasEfecto";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            MapaEfecto mapaMonstruo = (id != null) ? service.getByID(id) : new MapaEfecto();
            model.addAttribute("mapaEfecto", mapaMonstruo);
            return "admin/mapasEfecto";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el efecto de mapa para editar: " + e.getMessage());
            return "admin/mapasEfecto";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("mapaEfecto") MapaEfecto mapaMonstruo, Model model) throws IOException {
        try {
            service.setItem(mapaMonstruo);
            return "redirect:/admin/mapasEfecto";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el efecto de mapa: " + e.getMessage());
            return "admin/mapasEfecto";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/mapasEfecto";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el efecto de mapa: " + e.getMessage());
            return "admin/mapasEfecto";
        }
    }
}
