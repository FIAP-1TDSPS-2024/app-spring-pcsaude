package br.com.pcsaude.services;

import br.com.pcsaude.entities.Suporte;
import br.com.pcsaude.entities.Usuario;
import br.com.pcsaude.enums.SuporteStatusEnum;
import br.com.pcsaude.exceptions.ResourceNotFoundException;
import br.com.pcsaude.repositories.SuporteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SuporteService {

    private final SuporteRepository repository;

    public SuporteService(SuporteRepository repository) {
        this.repository = repository;
    }

    public Suporte findById(Long id) {
        try {
            return this.repository.findById(id).orElseThrow();
        }
        catch (NoSuchElementException e){
            throw new ResourceNotFoundException("Não foi possível encontrar um suporte com o id " + id);
        }
    }

    public Page<Suporte> findAll(int page, int size) {
        //TO DO Usuário deve ser definido por contexto
        Usuario usuario = new Usuario();

        return this.repository
                .findAllByUsuario_Id(
                        usuario.getId(),
                        Pageable
                                .ofSize(size)
                                .withPage(page));
    }

    public Suporte save(Suporte suporte) {
        return this.repository.save(suporte);
    }

    public Suporte cancelar(Long id) {
        Suporte suporte = this.findById(id);

        suporte.setStatus(SuporteStatusEnum.CANCELADO);

        return this.repository.save(suporte);
    }
}
