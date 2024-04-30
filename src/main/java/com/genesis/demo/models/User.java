package com.genesis.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull(message = "El nombre es requerido!")
    @Size(max = 100, message = "El nombre debe tener maximo 100 caracteres")
    private String fullName;
    /*@Pattern(regexp = "^(?:19|20)\\d{2}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12][0-9]|3[01])$",
            message = "La fecha no tiene el formato correcto!")*/
    private LocalDate birthDay;
    @NotNull(message = "El email es requerido!")
    @Email(message = "Email invalido!")
    private String email;
}
