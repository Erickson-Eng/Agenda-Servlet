package br.edu.ifpb.agenda.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "contact")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
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
    @JsonIgnore
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();
}