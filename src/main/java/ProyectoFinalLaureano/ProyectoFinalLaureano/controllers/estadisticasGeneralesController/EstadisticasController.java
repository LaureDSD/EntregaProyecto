package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers.estadisticasGeneralesController;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.estadisticasGenerales.EstadisticasGenerales;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.estadisticasDTO.EstadisticasSimpleDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.modelsDTO.estadisticasDTO.EstadisticasPersonajeDTO;
import ProyectoFinalLaureano.ProyectoFinalLaureano.services.estadisticasService.EstadisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticasController {

    @Autowired
    private EstadisticasService estadisticasService;

    //CRUD basico de Tipos
    @GetMapping("/")
    public List<EstadisticasGenerales> obtenerUsuario(){
        return  estadisticasService.getAll();
    }

    @GetMapping("/{id}")
    public EstadisticasGenerales obtener(@PathVariable Long id){
        return estadisticasService.getByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizar(@PathVariable Long id, @RequestBody EstadisticasGenerales estadisticaActualizar){
        if(estadisticaActualizar.getEstadisticasId().equals(id)) {
            return ResponseEntity.ok( estadisticasService.setItem(estadisticaActualizar) );
        }else{
                return ResponseEntity.badRequest().body("El ID proporcionado no coincide con el ID de las estadistcas.");
        }
    }

    @PostMapping("/")
    public EstadisticasGenerales guardar(@RequestBody EstadisticasGenerales estadisticasGuardar){
        return  estadisticasService.setItem(estadisticasGuardar);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        estadisticasService.deleteByID(id);
    }

    //Conversor Lista estaditicas
    public static List<EstadisticasSimpleDTO> conversorListaEstadisticasDTO (List<EstadisticasGenerales> le){
        return le.stream().map(EstadisticasController::conversorEstadisticasDTO).toList();
    }

    //Conversor  Unico estadisticas
    public static EstadisticasSimpleDTO conversorEstadisticasDTO (EstadisticasGenerales e) {
        EstadisticasSimpleDTO estadisticasDTO = new EstadisticasSimpleDTO();
        estadisticasDTO.setVidaBase(e.getVida());
        estadisticasDTO.setRegeneracionVidaBase(e.getRegeneracionVida());
        estadisticasDTO.setManaBase(e.getMana());
        estadisticasDTO.setRegeneracionManaBase(e.getRegeneracionMana());
        estadisticasDTO.setEnergiaBase(e.getEnergia());
        estadisticasDTO.setRegeneracionEnergiaBase(e.getRegeneracionEnergia());
        estadisticasDTO.setAtaqueFisicoBase(e.getAtaqueFisico());
        estadisticasDTO.setAtaqueMagicoBase(e.getAtaqueMagico());
        estadisticasDTO.setDefensaFisica(e.getDefensaFisica());
        estadisticasDTO.setDefensaMagica(e.getDefensaMagica());
        estadisticasDTO.setEscudoBase(e.getEscudo());
        return  estadisticasDTO;
    }

    //Conversor Lista Estadisticas persoanjes
    public static List<EstadisticasPersonajeDTO> conversorListaEstadisticasPersoanejeDTO (List<EstadisticasGenerales> le){
        List<EstadisticasPersonajeDTO> leDTO = new ArrayList<>();
        le.forEach(e -> leDTO.add(conversorEstadisticasPersoanejeDTO(e)) );
        return leDTO;
    }

    //Conversor Unico Estadisticas persoanje
    public static EstadisticasPersonajeDTO conversorEstadisticasPersoanejeDTO (EstadisticasGenerales e) {
        EstadisticasPersonajeDTO estadisticasDTO = new EstadisticasPersonajeDTO();
        estadisticasDTO.setVidaMax(e.getVida());
        estadisticasDTO.setRegeneracionVida(e.getRegeneracionVida());
        estadisticasDTO.setManaMax(e.getMana());
        estadisticasDTO.setRegeneracionMana(e.getRegeneracionMana());
        estadisticasDTO.setEnergiaMax(e.getEnergia());
        estadisticasDTO.setRegeneracionEnergia(e.getRegeneracionEnergia());
        estadisticasDTO.setAtaqueFisico(e.getAtaqueFisico());
        estadisticasDTO.setAtaqueMagico(e.getAtaqueMagico());
        estadisticasDTO.setDefensaFisica(e.getDefensaFisica());
        estadisticasDTO.setDefensaMagica(e.getDefensaMagica());
        estadisticasDTO.setEscudo(e.getEscudo());
        return  estadisticasDTO;
    }
}
