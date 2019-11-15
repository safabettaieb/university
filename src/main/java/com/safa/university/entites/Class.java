package com.safa.university.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
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
    private String name;
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
