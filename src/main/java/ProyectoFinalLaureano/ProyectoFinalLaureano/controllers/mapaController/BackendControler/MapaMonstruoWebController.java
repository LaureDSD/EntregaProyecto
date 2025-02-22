package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaMonstruoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/mapa/mapasMonstruo")
public class MapaMonstruoWebController {

    private final String rutaHTML ="/admin/mapa/mapasMonstruo";

    @Autowired
    private MapaMonstruoService service;

    @Autowired
    private MapaService mapaService;

    @Autowired
    private MonstruosService monstruosService;

    private List<Mapa> mapl;
    private List<Monstruo> monl;

    // Listado de Mapas de Monstruo
    @GetMapping
    public String listar(Model model) {
        try {
            mapl = mapaService.getAll();
            monl = monstruosService.getAll();
            List<MapaMonstruo> mapasMonstruo = service.getAll();
            model.addAttribute("mapasMonstruo", mapasMonstruo);
            model.addAttribute("mapaMonstruo", new MapaMonstruo());
            model.addAttribute("monstruoList", monl);
            model.addAttribute("mapaList", mapl);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los mapas de monstruo: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Formulario para crear o editar un Mapa de Monstruo
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            MapaMonstruo mapaMonstruo = (id != null) ? service.getByID(id) : new MapaMonstruo();
            model.addAttribute("mapaMonstruo", mapaMonstruo);
            model.addAttribute("monstruoList", monl);
            model.addAttribute("mapaList", mapl);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el mapa de monstruo para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Guardar un Mapa de Monstruo (creación o actualización)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("mapaMonstruo") MapaMonstruo mapaMonstruo, Model model) throws IOException {
        try {
            service.setItem(mapaMonstruo);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el mapa de monstruo: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Eliminar un Mapa de Monstruo
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el mapa de monstruo: " + e.getMessage());
            return rutaHTML;
        }
    }
}
