package ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.Item;
import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.itemRepository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAll(){
        return  itemRepository.findAll();
    }

    public Item getByID(Long id){
        return itemRepository.findById(id).orElse(null);
    }

    public Item setItem(Item o){
        return  itemRepository.save(o);
    }

    public  void deleteByID(Long id){
        itemRepository.deleteById(id);
    }

    public List<Item> getBytipoItem(TipoItem tipoItem) {
        return itemRepository.getBytipoItem(tipoItem);
    }
}
