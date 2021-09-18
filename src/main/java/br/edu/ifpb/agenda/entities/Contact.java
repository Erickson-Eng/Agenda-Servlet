package br.edu.ifpb.agenda.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "contact")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Contact implements Serializable {
    private static final long serialVersionUID = -3335574874135575186L;
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String cpf;
    private String rg;

    @ManyToOne
    private User user;
}