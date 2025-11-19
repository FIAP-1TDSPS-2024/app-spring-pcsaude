package br.com.pcsaude.records;

import br.com.pcsaude.enums.ModeloTrabalhoEnum;
import br.com.pcsaude.enums.Role;
import br.com.pcsaude.enums.SexoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UsuarioOutDto(

        Long id,

        @NotNull(message = "O nome do usuário não pode ser nulo")
        @Length(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String nome,

        @Email(message = "Insira um e-mail válido")
        @Length(max = 40, message = "O e-mail deve ter no máximo 40 caracteres")
        String email,

        @Digits(integer = 3, fraction = 2, message = "A altura deve ter até 3 dígitos antes e 2 após a vírgula")
        @DecimalMin(value = "0.0", message = "A altura não deve ser negativa")
        BigDecimal altura,

        @Digits(integer = 3, fraction = 2, message = "O peso deve ter até 3 dígitos antes e 2 após a vírgula")
        @DecimalMin(value = "0.0", message = "O peso não deve ser negativo")
        BigDecimal peso,

        @NotNull(message = "O sexo deve ser informado")
        @Enumerated(EnumType.STRING)
        SexoEnum sexo,

        @Enumerated(EnumType.STRING)
        ModeloTrabalhoEnum modeloTrabalho,

        @Enumerated(EnumType.STRING)
        Role role,

        LocalDate dataCadastro,

        String dispositivo_uuid
) {}
