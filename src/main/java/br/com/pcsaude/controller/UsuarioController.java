package br.com.pcsaude.controller;

import br.com.pcsaude.entities.Usuario;
import br.com.pcsaude.mappers.UsuarioMapper;
import br.com.pcsaude.records.UsuarioOutDto;
import br.com.pcsaude.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioOutDto> findById(@PathVariable Long id) {
        Usuario usuario = service.findById(id);
        UsuarioOutDto usuarioOutDto = UsuarioMapper.toDto(usuario);

        return ResponseEntity.ok(usuarioOutDto);
    }

    @PutMapping
    public ResponseEntity<UsuarioOutDto> update(@RequestBody Usuario usuario) {
        Usuario usuarioUpdate = service.update(usuario);
        UsuarioOutDto usuarioAtualizado =  UsuarioMapper.toDto(usuarioUpdate);
        return ResponseEntity.ok(usuarioAtualizado);
    }
}
