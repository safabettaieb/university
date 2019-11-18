package com.safa.university.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "le cin doit etre non null et sans epsace")
    @Size(max = 8,min = 8,message = "le cin ne dépaase passé 8 carctères")
    private String cin;

    @NotNull(message = "le nom doit etre non null et sans epsace")
    @Size(max = 45,message = "le nom ne dépaase passé pas 45 carctères")
    private String name;

    @ManyToMany(mappedBy = "teachers")
    @JsonIgnore
    List<Class> classes = new ArrayList<>();
}
