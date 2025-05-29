package cl.duocuc.asy.ferremas.services.service;

import cl.duocuc.asy.ferremas.model.Categoria;
import java.util.List;

public interface CategoriaService {
    Categoria crearCategoria(Categoria categoria);
    Categoria actualizarCategoria(Categoria categoria);
    void eliminarCategoria(Long id);
    Categoria buscarPorId(Long id);
    List<Categoria> findAll();
}
