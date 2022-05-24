package com.ferrosac.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table (name = "marca")
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE marca SET estado = true WHERE id_marca=?")
@Where(clause = "estado = false")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_marca")
    private Long id;
    @Column (name= "nombre", nullable = false)
    private String nombre;
    @Column (name= "estado", nullable = false)
    private boolean estado = Boolean.FALSE;

}
