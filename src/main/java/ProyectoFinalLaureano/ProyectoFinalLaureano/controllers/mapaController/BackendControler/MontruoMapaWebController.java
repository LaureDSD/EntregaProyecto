package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaMonstruoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/mapasMonstruo")
public class MontruoMapaWebController {

    @Autowired
    private MapaMonstruoService service;

    @GetMapping
    public String listar(Model model) {
        try {
            List<MapaMonstruo> mapasMonstruo = service.getAll();
            model.addAttribute("mapasMonstruo", mapasMonstruo);
            return "admin/mapasMonstruo";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los mapas de monstruo: " + e.getMessage());
            return "admin/mapasMonstruo";
        }
    }
/*
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            MapaMonstruo mapaMonstruo = (id != null) ? service.getByID(id) : new MapaMonstruo();
            model.addAttribute("mapaMonstruo", mapaMonstruo);
            return "admin/mapasMonstruo";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el mapa de monstruo para editar: " + e.getMessage());
            return "admin/mapasMonstruo";
        }
    }*/

    @PostMapping("/save")
    public String guardar(@ModelAttribute("mapaMonstruo") MapaMonstruo mapaMonstruo, Model model) throws IOException {
        try {
            service.setItem(mapaMonstruo);
            return "redirect:/admin/mapasMonstruo";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el mapa de monstruo: " + e.getMessage());
            return "admin/mapasMonstruo";
        }
    }
/*
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/mapasMonstruo";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el mapa de monstruo: " + e.getMessage());
            return "admin/mapasMonstruo";
        }
    }*/
}
