package br.edu.ifpb.agenda.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "address")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Address implements Serializable {
    private static final long serialVersionUID = 4990713753962826585L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private Integer number;
    private String complement;
    private String district;
    private String cep;
    private String city;
    private String state;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Contact contact;
}