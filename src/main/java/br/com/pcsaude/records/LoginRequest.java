package br.com.pcsaude.records;

public record LoginRequest(
        String email,
        String password
) {}
