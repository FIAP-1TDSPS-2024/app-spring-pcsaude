package br.com.pcsaude.repositories;

import br.com.pcsaude.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findFirstByNome(String nome);
    public Usuario findFirstByEmail(String email);

    Optional<Usuario> findByEmail(String email);
}
