package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.securityController.BackendControler;

import ProyectoFinalLaureano.ProyectoFinalLaureano.config.security.JwtService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.config.security.UserDetailsServiceImpl;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.TipoUsuarioService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
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

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

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
            usuario.setUsuario_id(null);
            usuario.setLimite_personajes(3);
            usuario.setFecha_creacion(new Date());
            usuario.setUltima_conexion(new Date());
            usuario.setEstado_cuenta(true);


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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/registro")
    public ResponseEntity<Map<String, String>> register(@RequestBody Usuario usuario) {
        Map<String, String> response = new HashMap<>();
        try {
            usuario.setUsuario_id(null);
            usuario.setLimite_personajes(3);
            usuario.setFecha_creacion(new Date());
            usuario.setUltima_conexion(new Date());
            usuario.setEstado_cuenta(true);
            usuario.setTipoUsuario(tipoUsuarioService.getByID(1L));

            if (usuarioService.setItem(usuario) != null) {
                response.put("message", "Usuario registrado exitosamente");
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                response.put("error", "Error al guardar el usuario");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            response.put("error", "Error al registrar: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String correo, @RequestParam String contraseña, HttpServletRequest request) {
        try {
            // Autenticar al usuario
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(correo, contraseña)
            );

            // Cargar los detalles del usuario
            UserDetails userDetails = userDetailsService.loadUserByUsername(correo);

            // Obtener el rol del usuario
            String role = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No se encontró un rol para el usuario"));

            // Generar el token JWT
            String token = jwtService.generateToken(userDetails.getUsername(), role);

            // Guardar el usuario autenticado en la sesión de Spring Security
            SecurityContextHolder.getContext().setAuthentication(authentication);
            request.getSession().setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

            // Devolver el token en la respue
            System.out.println(token);
            return ResponseEntity.ok().body(Map.of("token", token));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Error en la autenticación"));
        }
    }

    /*@GetMapping("admin/dashboard")
    public String getDashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Usuario autenticado: " + authentication.getName());
        System.out.println("Roles: " + authentication.getAuthorities());

        model.addAttribute("usuario", authentication.getName());
        return "/admin/dashboard"; // Thymeleaf buscará /templates/admin/dashboard.html
    }*/


    /*@PostMapping("/login")
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
    }*/
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