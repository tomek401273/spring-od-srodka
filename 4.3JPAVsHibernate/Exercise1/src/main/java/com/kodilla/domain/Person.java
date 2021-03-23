package com.kodilla.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;

//    @ManyToMany
//    @JoinTable(
//            joinColumns = @JoinColumn(name = "person_id"),
//            inverseJoinColumns = @JoinColumn(name = "task_id")
//    )
//    private List<Task> taskList =new ArrayList<>();
//
//    @ManyToMany
//    @JoinTable(
//            joinColumns = @JoinColumn(name = "person_id"),
//            inverseJoinColumns = @JoinColumn(name = "subtask_id")
//    )
//    private List<Task> subTaskList =new ArrayList<>();

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
