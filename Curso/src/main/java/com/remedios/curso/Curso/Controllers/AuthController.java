package com.remedios.curso.Curso.Controllers;

import com.remedios.curso.Curso.infra.DadosTokenJWT;
import com.remedios.curso.Curso.infra.TokenService;
import com.remedios.curso.Curso.usuario.DTO.DadosAuth;
import com.remedios.curso.Curso.usuario.Usuario;
import com.remedios.curso.Curso.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAuth dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.nome(), dados.senha());
        var autenticacao = authenticationManager.authenticate(token);
        var tokenJWT = tokenService.generateToken((Usuario) autenticacao.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}
