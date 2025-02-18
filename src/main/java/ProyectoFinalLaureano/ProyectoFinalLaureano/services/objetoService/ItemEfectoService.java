package ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.efecto.ItemEfectoId;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.objetoRepository.ItemEfectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemEfectoService {
    @Autowired
    ItemEfectoRepository itemEfectoRepository;

    public List<ItemEfecto> getAll(){
        return  itemEfectoRepository.findAll();
    }

    public ItemEfecto getByID(ItemEfectoId id){
        return itemEfectoRepository.findById(id).orElse(null);
    }

    public ItemEfecto setItem(ItemEfecto o){
        return  itemEfectoRepository.save(o);
    }

    public  void deleteByID(ItemEfectoId id){
        itemEfectoRepository.deleteById(id);
    }

    public List<ItemEfecto> getByObjetoId(Long itemId) {
        return itemEfectoRepository.getByItemId(itemId);
    }
}
