package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.monstruoController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.Monstruo;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.monstruo.drops.DropsObjetos;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.monsrtuoDTO.DropsDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.monsrtuoDTO.MonstruoDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.monstruoService.MonstruosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monstruo")
@Tag(name = "Monstruo", description = "API para gestionar monstruos")
public class MonstruoController {

    @Autowired
    private MonstruosService monstruosService;

    @GetMapping("/")
    @Operation(summary = "Obtener todos los monstruos")
    public List<MonstruoDTO> obtenerListaMonstruos() {
        return conversorListaMonstruoDTO(monstruosService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un monstruo por ID")
    public MonstruoDTO obtenerMonstruo(@PathVariable Long id) {
        return conversorMonstruoDTO(monstruosService.getByID(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un monstruo por ID")
    public ResponseEntity<Object> actualizarMonstruo(@PathVariable Long id, @RequestBody Monstruo monstruoActualizar) {
        if (monstruoActualizar.getMonstruoId().equals(id)) {
            return ResponseEntity.ok(conversorMonstruoDTO(monstruosService.setItem(monstruoActualizar)));
        } else {
            return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID del monstruo.");
        }
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo monstruo")
    public MonstruoDTO guardarMonstruo(@RequestBody Monstruo monstruoGuardar) {
        return conversorMonstruoDTO(monstruosService.setItem(monstruoGuardar));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un monstruo por ID")
    public void borrarMonstruo(@PathVariable Long id) {
        monstruosService.deleteByID(id);
    }

    // Conversor Lista
    public static List<MonstruoDTO> conversorListaMonstruoDTO(List<Monstruo> l) {
        return l.stream().map(MonstruoController::conversorMonstruoDTO).toList();
    }

    // Conversor Unico DTO
    public static MonstruoDTO conversorMonstruoDTO(Monstruo m) {
        MonstruoDTO monstruoDTO = new MonstruoDTO();
        monstruoDTO.setId(m.getMonstruoId());
        monstruoDTO.setImagen(m.getImagen());
        monstruoDTO.setNombre(m.getNombre());
        monstruoDTO.setDescripcion(m.getDescripcion());
        monstruoDTO.setAlmas(m.getAlmasOtrogadas());
        monstruoDTO.setExperiencia(m.getExperienciaOtorgada());
        monstruoDTO.setEstadisticas(m.getEstadisticas());
        monstruoDTO.setDrops(conversorListaDropsDTO(m.getDrops()));
        return monstruoDTO;
    }

    // Conversor Lista Drops
    public static List<DropsDTO> conversorListaDropsDTO(List<DropsObjetos> l) {
        return l.stream().map(MonstruoController::conversorDropsDTO).toList();
    }

    // Conversor Unico Drops
    private static DropsDTO conversorDropsDTO(DropsObjetos dropsObjetos) {
        DropsDTO dropsDTO = new DropsDTO();
        dropsDTO.setItem(dropsObjetos.getItem());
        dropsDTO.setProbabilidad(dropsObjetos.getProbabilidad());
        return dropsDTO;
    }
}