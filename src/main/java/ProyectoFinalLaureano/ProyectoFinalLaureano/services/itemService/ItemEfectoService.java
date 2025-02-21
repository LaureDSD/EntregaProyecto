package ProyectoFinalLaureano.ProyectoFinalLaureano.services.itemService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.item.ItemEfecto;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.itemRepository.ItemEfectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemEfectoService {
    @Autowired
    ItemEfectoRepository itemEfectoRepository;

    public List<ItemEfecto> getAll() {
        return itemEfectoRepository.findAll();
    }

    public ItemEfecto getByID(Long id) {
        return itemEfectoRepository.findById(id).orElse(null);
    }

    public ItemEfecto setItem(ItemEfecto o) {
        return itemEfectoRepository.save(o);
    }

    public void deleteByID(Long id) {
        itemEfectoRepository.deleteById(id);
    }

}
