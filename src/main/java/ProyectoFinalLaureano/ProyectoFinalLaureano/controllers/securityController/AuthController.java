package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.securityController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.config.security.JwtService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.config.security.UserDetailsServiceImpl;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtService jwtService;

    // Método GET para mostrar el formulario de login
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Retorna la plantilla login.html
    }

    // Método GET para mostrar el formulario de registro
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // Retorna la plantilla register.html
    }

    // Método POST para manejar el registro
    @PostMapping("/register")
    public String register(@ModelAttribute Usuario usuario, Model model) {
        try {
            usuario.setUsuario_id(null); // Asegúrate de que el ID sea nulo para crear un nuevo usuario
            usuario.setLimite_personajes(3); // Establece el límite de personajes
            usuario.setFecha_creacion(LocalDateTime.now()); // Establece la fecha de creación
            usuario.setUltima_conexion(LocalDateTime.now()); // Establece la fecha de inicio de sesión
            usuario.setEstado_cuenta(true); // Establece el estado de la cuenta como activa


            if (usuarioService.setItem(usuario) == null) {
                model.addAttribute("error", "Error al guardar usuario");
                return "register"; // Muestra el formulario de registro con el mensaje de error
            }
            return "redirect:/auth/login?registroExitoso=true"; // Redirige al login después del registro
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar: " + e.getMessage());
            return "register"; // Muestra el formulario de registro con el mensaje de error
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String correo, @RequestParam String contraseña, Model model) {
        try {
            System.out.println("Intentando login para: " + correo);

            // Intentar autenticar al usuario
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(correo, contraseña)
            );
            System.out.println("Autenticación exitosa");

            // Si la autenticación es exitosa, obtener los detalles del usuario
            UserDetails userDetails = userDetailsService.loadUserByUsername(correo);

            // Generar el token JWT
            String token = jwtService.generateToken(userDetails.getUsername());

            // Devolver el token en la respuesta
            return ResponseEntity.ok().body(Map.of("token", token));

        } catch (Exception e) {
            System.out.println("Error en login: " + e.getMessage());
            model.addAttribute("error", "Error en la autenticación: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Error en la autenticación"));
        }
    }
}

//fetch('/login', {
//    method: 'POST',
//    body: JSON.stringify({ correo: 'usuario@example.com', contraseña: 'contraseña' }),
//    headers: { 'Content-Type': 'application/json' }
//})
//.then(response => response.json())
//.then(data => {
//    localStorage.setItem('token', data.token); // Almacenar el token
//    window.location.href = '/admin'; // Redirigir al panel de control
//});