package br.com.pcsaude.controller;

import br.com.pcsaude.entities.Usuario;
import br.com.pcsaude.mappers.UsuarioMapper;
import br.com.pcsaude.records.UsuarioOutDto;
import br.com.pcsaude.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public UsuarioOutDto findById(@PathVariable Long id) {
        Usuario usuario = service.findById(id);
        return UsuarioMapper.toDto(usuario);
    }

    @PutMapping
    public UsuarioOutDto update(@RequestBody Usuario usuario) {
        Usuario usuarioUpdate = service.update(usuario);
        return UsuarioMapper.toDto(usuarioUpdate);
    }
}
