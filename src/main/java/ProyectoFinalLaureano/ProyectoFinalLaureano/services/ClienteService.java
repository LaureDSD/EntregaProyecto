package ProyectoFinalLaureano.ProyectoFinalLaureano.services;

import ad.RepasoExamen.Model.Cliente;
import ad.RepasoExamen.ModelDTO.ClienteDTO;
import ad.RepasoExamen.ModelDTO.ClienteV2DTO;
import ad.RepasoExamen.ModelDTO.ClienteV3DTO;
import ad.RepasoExamen.ModelDTO.FacturaV2DTO;
import ad.RepasoExamen.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static ad.RepasoExamen.Security.ControladorSeguridad.ocultarEmail;
import static ad.RepasoExamen.Security.ControladorSeguridad.ocultarNumero;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FacturaService facturaService;

    public List<ClienteDTO> getAll(){
        return  mappingDTOlist(clienteRepository.findAll());
    }
    public Cliente getByID(Long id){
        return clienteRepository.findById(id).orElse(null);
    }
    public Cliente setItem(Cliente c){
        return  clienteRepository.save(c);
    }
    public  void deleteByID(Long id){
        clienteRepository.deleteById(id);
    }

    public ClienteV2DTO getByIDFacturacion(Long id) {
        return mappingV2DTO(clienteRepository.findById(id).orElse(null));
    }

    //V1.0
    public ClienteDTO mappingDTO (Cliente cl){
        Cliente c = cl;
        ClienteDTO cd = new ClienteDTO();
        cd.setNif(ocultarNumero(c.getNif(),4));
        cd.setNombre(c.getNombre());
        cd.setApellidos(c.getApellidos());
        cd.setTelefono(ocultarNumero(c.getTelefono(),3));
        cd.setDireccion(c.getDireccion());
        cd.setEmail(ocultarEmail(c.getEmail(),4));
        return cd;
    }
    private List<ClienteDTO> mappingDTOlist(List<Cliente> list){
        return list.stream().map(this::mappingDTO).toList();
    }


    //V2.0
    public ClienteV2DTO mappingV2DTO (Cliente cl){
        Cliente c = cl;
        ClienteV2DTO cd = new ClienteV2DTO();
        cd.setId(c.getId());
        cd.setNombre(c.getNombre());
        cd.setApellidos(c.getApellidos());
        cd.setEmail(c.getEmail());
        cd.setTelefono(c.getTelefono());
        cd.setDireccion(c.getDireccion());
        cd.setNif(c.getNif());
        cd.setFechacreacion(c.getFechacreacion());
        cd.setUsuario(c.getUsuario());
        cd.setContrasena(c.getContrasena());
        cd.setCategoria(c.getCategoria());
        cd.setInformacion(c.getInformacion());
        //MappingFacturasV2
        List<FacturaV2DTO> fv2 = facturaService.mappingV2DTOlist(c.getFacturas());
        cd.setFacturas(fv2);
        double total = 0;
        for(FacturaV2DTO f : fv2){
            total += f.getImporteTotal();
        }
        cd.setTotalFacturacion(total);
        return cd;
    }
    private List<ClienteV2DTO> mappingV2DTOlist(List<Cliente> list){
        return list.stream().map(this::mappingV2DTO).toList();
    }


    //V3.0
    public ClienteV3DTO mappingV3DTO (Cliente cl){
        Cliente c = cl;
        ClienteV3DTO cd = new ClienteV3DTO();
        cd.setNombre(c.getNombre()+ c.getApellidos());
        cd.setDireccion(c.getDireccion());
        cd.setTelefono(c.getTelefono());
        cd.setEmail(c.getEmail());
        return cd;
    }
    private List<ClienteV3DTO> mappingV3DTOlist(List<Cliente> list){
        return list.stream().map(this::mappingV3DTO).toList();
    }


    private Cliente getByUsuario(String usuario) {
        return clienteRepository.getByUsuario(usuario);
    }

    public Boolean validacion (String usuario, String contrasena){
        Cliente cl = getByUsuario(usuario);
        return cl!=null && (cl.getUsuario().equals(usuario)) && (cl.getContrasena().equals(contrasena));
    }


}
