package cl.duocuc.asy.ferremas.services.service;

import cl.duocuc.asy.ferremas.model.SubCategoria;
import java.util.List;

public interface SubCategoriaService {
    SubCategoria crearSubCategoria(SubCategoria subCategoria);
    SubCategoria actualizarSubCategoria(SubCategoria subCategoria);
    void eliminarSubCategoria(Long id);
    SubCategoria buscarPorId(Long id);
    List<SubCategoria> findAll();
    List<SubCategoria> findByCategoriaId(Long categoriaId);
}
