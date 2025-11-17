package br.com.pcsaude.services;

import br.com.pcsaude.entities.Alerta;
import br.com.pcsaude.entities.Suporte;
import br.com.pcsaude.entities.Usuario;
import br.com.pcsaude.repositories.AlertaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class AlertaService {

    private final AlertaRepository repository;

    public AlertaService(AlertaRepository repository) {
        this.repository = repository;
    }

    public Alerta findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Page<Alerta> findAll(int page, int size) {
        //TO DO Usuário deve ser definido por contexto
        Usuario usuario = new Usuario();

        return this.repository
                .findAllByUsuario_Id(
                        usuario.getId(),
                        Pageable
                                .ofSize(size)
                                .withPage(page));
    }

    public Alerta save(Alerta alerta) {
        return this.repository.save(alerta);
    }
}
