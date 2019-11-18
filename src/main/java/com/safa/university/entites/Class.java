package com.safa.university.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "le nom doit etre non null")
    @Size(max = 45,message = "la taille ne dépasse pas  45 carctere")
    private String name;

    @NotNull(message = "le nombre doit etre non null")
    @Positive(message = "la nombre de class doit etre posstivie")
    private int maxnum;

    @OneToMany(mappedBy ="aClass" ) //bch maysana3lich table o5ra
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Student> students = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "class_teacher",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
            )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Teacher> teachers= new ArrayList<>();

}
