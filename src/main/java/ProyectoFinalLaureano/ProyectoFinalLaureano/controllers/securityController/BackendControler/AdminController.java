package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.securityController.BackendControler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "admin/dashboard"; // Vista en templates/admin/dashboard.html
    }
}