package cl.duocuc.asy.ferremas.services.serviceImpl;

import cl.duocuc.asy.ferremas.model.Categoria;
import cl.duocuc.asy.ferremas.repository.CategoriaRepository;
import cl.duocuc.asy.ferremas.services.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula");
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        if (categoria == null || categoria.getId() == null) {
            throw new IllegalArgumentException("La categoría o su ID no pueden ser nulos");
        }
        if (!categoriaRepository.existsById(categoria.getId())) {
            throw new IllegalArgumentException("La categoría con el ID especificado no existe");
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de la categoría no puede ser nulo");
        }
        if (!categoriaRepository.existsById(id)) {
            throw new IllegalArgumentException("La categoría con el ID especificado no existe");
        }
        categoriaRepository.deleteById(id);
    }

    @Override
    public Categoria buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de la categoría no puede ser nulo");
        }
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}