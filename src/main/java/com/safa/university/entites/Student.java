package com.safa.university.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    @NotBlank(message = "valeur non null et sans espace")
    @Size(max = 8,min = 8 , message = "la taille ne dépasse pas  8 carctere")
    private String cin;

    @NotBlank(message = "valeur non null et sans espace")
    @Size(max = 45 , message = "la taille ne dépasse pas  45 carctere")
   private String name;

    @Past(message = "la date doit etre dans le passé")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
   private LocalDate dob;

   @ManyToOne
   private Class aClass;
}
