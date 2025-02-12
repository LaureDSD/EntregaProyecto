package ProyectoFinalLaureano.ProyectoFinalLaureano.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {

    /*
    @Autowired
    private FacturaService facturaService;


    @GetMapping
    public List<Factura> obtenerTodos(){
        return  facturaService.getAll();


    //Get DTO V1
    @GetMapping
    public List<FacturaDTO> obtenerLista(@RequestParam(required = false) Long id){
        if(id==null){
            return  facturaService.getAll();
        }else{
            var c = new Cliente();
            c.setId(id);
            return facturaService.getByCliente(c);
        }

    }

    //GET SIN DTO
    @GetMapping("/{id}")
    public FacturaV3DTO obtener(@PathVariable Long id){
        return facturaService.getByID(id);
    }


    @PutMapping("/{id}")
    public  Factura actualizar(@PathVariable Long id, @RequestBody Factura f){
        f.setId(id);
        return  facturaService.setItem(f);
    }

    @PostMapping
    public Factura guardar(@RequestBody Factura f){
        return  facturaService.setItem(f);
    }

    @DeleteMapping("/{id}")
    public void borrar (@PathVariable Long id){
        facturaService.deleteByID(id);
    }


*/
}
