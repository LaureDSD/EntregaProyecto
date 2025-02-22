package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.logController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.log.LogTransacciones;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.npc.Npc;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.personaje.Personaje;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService.ItemService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.logService.LogTransaccionesService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.npcService.NpcService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.persoanjeService.PersoanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/logTransacciones")
public class LogTransaccionesWebController {

    @Autowired
    private LogTransaccionesService service;
    @Autowired
    private PersoanjeService persoanjeService;
    @Autowired
    private NpcService npcService;
    @Autowired
    private ItemService itemService;

    private List<Personaje> pl;
    private List<Npc> nl;
    private List<Item> il;


    @GetMapping
    public String listar(Model model) {
        try {
            try{pl =persoanjeService.getAll();}catch (Exception e){throw  e;}
            try{nl =npcService.getAll();}catch (Exception e){throw  e;}
            try{il = itemService.getAll();}catch (Exception e){throw  e;}
            List<LogTransacciones> logTransacciones = service.getAll();
            model.addAttribute("logTransacciones", logTransacciones);
            model.addAttribute("logTransaccion", new LogTransacciones());
            model.addAttribute("personajeList", pl);
            model.addAttribute("itemList", il);
            model.addAttribute("npcList", nl);
            return "admin/logTransacciones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar los logs de transacciones: " + e.getMessage());
            return "admin/logTransacciones";
        }
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        try {
            LogTransacciones logTransacciones = (id != null) ? service.getByID(id) : new LogTransacciones();
            model.addAttribute("logTransaccion", logTransacciones);
            model.addAttribute("personajeList", pl);
            model.addAttribute("itemList", pl);
            model.addAttribute("npcList", nl);
            return "admin/logTransacciones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el log de transacciones para editar: " + e.getMessage());
            return "admin/logTransacciones";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("logTransaccion") LogTransacciones logTransacciones, Model model) throws IOException {
        try {
            logTransacciones.setFecha_transaccion( new Date());
            service.setItem(logTransacciones);
            return "redirect:/admin/logTransacciones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el log de transacciones: " + e.getMessage());
            return "admin/logTransacciones";
        }
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteByID(id);
            return "redirect:/admin/logTransacciones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el log de transacciones: " + e.getMessage());
            return "admin/logTransacciones";
        }
    }
}
