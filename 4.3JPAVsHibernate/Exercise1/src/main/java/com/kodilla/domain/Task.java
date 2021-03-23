package com.kodilla.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String status;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany(mappedBy = "taskList", targetEntity = SubTask.class)
    private List<SubTask> subTaskList = new ArrayList<>();

    public Task(String name, String status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
