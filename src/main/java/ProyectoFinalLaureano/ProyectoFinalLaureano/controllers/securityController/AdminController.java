package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.securityController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    // Método GET para mostrar el panel de administración
    @GetMapping
    public String mostrarPanel() {
        return "panel"; // Retorna la plantilla panel.html
    }

    // Métodos GET para redirigir a las vistas de edición de cada tabla
    @GetMapping("/usuarios")
    public String gestionarUsuarios() {
        return "redirect:/admin/usuarios/editar"; // Redirige a la gestión de usuarios
    }

    @GetMapping("/personajes")
    public String gestionarPersonajes() {
        return "redirect:/admin/personajes/editar"; // Redirige a la gestión de personajes
    }

    @GetMapping("/grupos")
    public String gestionarGrupos() {
        return "redirect:/admin/grupos/editar"; // Redirige a la gestión de grupos
    }

    @GetMapping("/monstruos")
    public String gestionarMonstruos() {
        return "redirect:/admin/monstruos/editar"; // Redirige a la gestión de monstruos
    }

    @GetMapping("/items")
    public String gestionarItems() {
        return "redirect:/admin/items/editar"; // Redirige a la gestión de items
    }

    @GetMapping("/misiones")
    public String gestionarMisiones() {
        return "redirect:/admin/misiones/editar"; // Redirige a la gestión de misiones
    }

    @GetMapping("/npcs")
    public String gestionarNPCs() {
        return "redirect:/admin/npcs/editar"; // Redirige a la gestión de NPCs
    }

    @GetMapping("/mapas")
    public String gestionarMapas() {
        return "redirect:/admin/mapas/editar"; // Redirige a la gestión de mapas
    }
}