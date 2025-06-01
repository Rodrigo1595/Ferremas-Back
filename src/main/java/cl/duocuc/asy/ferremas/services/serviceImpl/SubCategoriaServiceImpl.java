package cl.duocuc.asy.ferremas.services.serviceImpl;

import cl.duocuc.asy.ferremas.model.SubCategoria;
import cl.duocuc.asy.ferremas.repository.SubCategoriaRepository;
import cl.duocuc.asy.ferremas.services.service.SubCategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SubCategoriaServiceImpl implements SubCategoriaService {

    private final SubCategoriaRepository subCategoriaRepository;

    @Override
    public SubCategoria crearSubCategoria(SubCategoria subCategoria) {
        return subCategoriaRepository.save(subCategoria);
    }

    @Override
    public SubCategoria actualizarSubCategoria(SubCategoria subCategoria) {
        return subCategoriaRepository.save(subCategoria);
    }

    @Override
    public void eliminarSubCategoria(Long id) {
        subCategoriaRepository.deleteById(id);
    }

    @Override
    public SubCategoria buscarPorId(Long id) {
        return subCategoriaRepository.findById(id).orElse(null);
    }

    @Override
    public List<SubCategoria> findAll() {
        return subCategoriaRepository.findAll();
    }
}