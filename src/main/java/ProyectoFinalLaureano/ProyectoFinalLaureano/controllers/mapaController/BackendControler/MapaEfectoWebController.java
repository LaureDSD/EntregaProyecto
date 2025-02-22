package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.efectosEstados.EfectoEstado;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogPersonajeMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaMonstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.efectoEstadoService.EfectoEstadoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaEfectoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaMonstruoService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.TipoMapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/mapa/mapasEfecto")
public class MapaEfectoWebController {

    private final String rutaHTML ="/admin/mapa/mapasEfecto";

    @Autowired
    private MapaEfectoService service;

    @Autowired
    private MapaService mapaService;

    @Autowired
    private EfectoEstadoService efectoEstadoService;

    private List<Mapa> ml;
    private List<EfectoEstado> el;



    @GetMapping
    public String listar(Model model) {
        try {
             ml = mapaService.getAll();
             el = efectoEstadoService.getAll();
            List<MapaEfecto> mapasMonstruo = service.getAll();
            model.addAttribute("mapasEfecto", mapasMonstruo);
            model.addAttribute("mapaEfecto", new MapaEfecto());
            model.addAttribute("mapaList", ml);
            model.addAttribute("efectoList", el);


            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los efectos de mapa: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            MapaEfecto mapaMonstruo = (id != null) ? service.getByID(id) : new MapaEfecto();
            model.addAttribute("mapaEfecto", mapaMonstruo);
            model.addAttribute("mapaList", ml);
            model.addAttribute("efectoList", el);
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el efecto de mapa para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("mapaEfecto") MapaEfecto mapaMonstruo, Model model) throws IOException {
        try {
            service.setItem(mapaMonstruo);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el efecto de mapa: " + e.getMessage());
            return rutaHTML;
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el efecto de mapa: " + e.getMessage());
            return rutaHTML;
        }
    }
}
