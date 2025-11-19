package br.com.pcsaude.controller;

import br.com.pcsaude.entities.Dispositivo;
import br.com.pcsaude.entities.Usuario;
import br.com.pcsaude.mappers.UsuarioMapper;
import br.com.pcsaude.records.AuthResponse;
import br.com.pcsaude.records.LoginRequest;
import br.com.pcsaude.records.UsuarioInDto;
import br.com.pcsaude.records.UsuarioOutDto;
import br.com.pcsaude.security.JwtUtil;
import br.com.pcsaude.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UsuarioService usuarioService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UsuarioService usuarioService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        String token = jwtUtil.generateToken(authentication);

        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        AuthResponse response = new AuthResponse(token, request.email(), roles);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioOutDto> cadastrar(@Valid @RequestBody UsuarioInDto dto) {

        Dispositivo dispositivo = new Dispositivo(dto.dispositivo_uuid());

        Usuario usuario = UsuarioMapper.fromDto(dispositivo, dto);

        Usuario novoUsuario = this.usuarioService.save(usuario);

        return ResponseEntity.ok(UsuarioMapper.toDto(novoUsuario));
    }
}
