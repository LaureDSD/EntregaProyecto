package ProyectoFinalLaureano.ProyectoFinalLaureano.services.objetoService;

import ProyectoFinalLaureano.ProyectoFinalLaureano.models.objeto.TipoItem;
import ProyectoFinalLaureano.ProyectoFinalLaureano.repositories.objetoRepository.TipoItemReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoItemService {
    @Autowired
    private TipoItemReposiory tipoItemReposiory;

    public List<TipoItem> getAll(){
        return  tipoItemReposiory.findAll();
    }

    public TipoItem getByID(Long id){
        return tipoItemReposiory.findById(id).orElse(null);
    }

    public TipoItem setItem(TipoItem o){
        return  tipoItemReposiory.save(o);
    }

    public  void deleteByID(Long id){
        tipoItemReposiory.deleteById(id);
    }
}
