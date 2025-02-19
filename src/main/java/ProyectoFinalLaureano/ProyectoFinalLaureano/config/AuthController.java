package ProyectoFinalLaureano.ProyectoFinalLaureano.config;



import ProyectoFinalLaureano.ProyectoFinalLaureano.config.security.JwtService;
import ProyectoFinalLaureano.ProyectoFinalLaureano.config.security.UserDetailsServiceImpl;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.usuario.Usuario;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.usuarioService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
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


    @PostMapping("/register")
    public String register(@RequestBody Usuario usuario) {
        try {
            usuario.setUsuarioId(null);
            if(usuarioService.setItem(usuario) == null){
                return "Error al guardar usuario";
            }
            return "Usuario registrado con éxito";
        } catch (Exception e) {
            return "Error al registrar: " + e.getMessage();
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        try {
            System.out.println("Intentando login para: " + usuario.getCorreo());

            // Intentar autenticar al usuario
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuario.getCorreo(), usuario.getContraseña())
            );
            System.out.println("Autenticación exitosa");

            // Si la autenticación es exitosa, obtener los detalles del usuario
            UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getCorreo());

            // Generar y devolver el token JWT
            return jwtService.generateToken(userDetails.getUsername());
        } catch (Exception e) {
            System.out.println("Error en login: " + e.getMessage());
            throw new RuntimeException("Error en la autenticación: " + e.getMessage());
        }
    }

}
