package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.securityController.BackendControler;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    /*@GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "admin/dashboard"; // Vista en templates/admin/dashboard.html
    }*/



    @GetMapping("/dashboard")
    public String getDashboard(Model model, Authentication authentication) {
        if (authentication != null) {
            // Obtener el usuario autenticado
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

            // Obtener roles
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            // Agregar al modelo
            model.addAttribute("usuario", username);
            model.addAttribute("roles", roles);
        }

        return "admin/dashboard";
    }
}


