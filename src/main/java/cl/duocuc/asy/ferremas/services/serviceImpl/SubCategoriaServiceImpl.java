package cl.duocuc.asy.ferremas.services.serviceImpl;

import cl.duocuc.asy.ferremas.model.SubCategoria;
import cl.duocuc.asy.ferremas.repository.SubCategoriaRepository;
import cl.duocuc.asy.ferremas.services.service.SubCategoriaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class SubCategoriaServiceImpl implements SubCategoriaService {

    private final SubCategoriaRepository subCategoriaRepository;

    @Override
    public SubCategoria crearSubCategoria(SubCategoria subCategoria) {
        if (subCategoria == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La subcategoría no puede ser nula");
        }
        return subCategoriaRepository.save(subCategoria);
    }

    @Override
    public SubCategoria actualizarSubCategoria(SubCategoria subCategoria) {
        if (subCategoria == null || subCategoria.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La subcategoría o su ID no pueden ser nulos");
        }
        if (!subCategoriaRepository.existsById(subCategoria.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La subcategoría con el ID especificado no existe");
        }
        return subCategoriaRepository.save(subCategoria);
    }

    @Override
    public void eliminarSubCategoria(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID de la subcategoría no puede ser nulo");
        }
        if (!subCategoriaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La subcategoría con el ID especificado no existe");
        }
        subCategoriaRepository.deleteById(id);
    }

    @Override
    public SubCategoria buscarPorId(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID de la subcategoría no puede ser nulo");

        }
        return subCategoriaRepository.findById(id).orElse(null);
    }

    @Override
    public List<SubCategoria> findAll() {
        return subCategoriaRepository.findAll();
    }

    @Override
    public List<SubCategoria> findByCategoriaId(Long categoriaId) {
        if (categoriaId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID de la categoría no puede ser nulo");
        }
        return subCategoriaRepository.findByCategoriaId(categoriaId);
    }
}