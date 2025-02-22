package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.mapaController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.Mapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.MapaEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.mapa.TipoMapa;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.MapaService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.mapaService.TipoMapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/mapa/mapas")
public class MapaWebController {

    private final String rutaHTML ="/admin/mapa/mapas";

    @Autowired
    private MapaService service;

    @Autowired
    private TipoMapaService tipoMapaService;

    private List<TipoMapa> tml;

    // Listado de Mapas
    @GetMapping
    public String listar(Model model) {
        try {
            tml =  tipoMapaService.getAll();
            List<Mapa> mapas = service.getAll();
            model.addAttribute("mapas", mapas);
            model.addAttribute("mapa", new Mapa());
            model.addAttribute("tiposMapa",tml );
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los mapas: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Formulario para crear o editar un Mapa
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            Mapa mapa = (id != null) ? service.getByID(id) : new Mapa();
            model.addAttribute("mapa", mapa);
            model.addAttribute("tiposMapa",tml );
            return rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el mapa para editar: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Guardar un Mapa (creación o actualización)
    @PostMapping("/save")
    public String guardar(@ModelAttribute("mapa") Mapa mapa, Model model) throws IOException {
        try {
            service.setItem(mapa);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el mapa: " + e.getMessage());
            return rutaHTML;
        }
    }

    // Eliminar un Mapa
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:"+rutaHTML;
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el mapa: " + e.getMessage());
            return rutaHTML;
        }
    }
}
