/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest.ApiRest.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *
 * @author fernan
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Servidor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    private String ip;
    private String nombre;
    private String memoria;
    private String disco;
    private String procesador;
    private String ubicacion;
    private String sistemaOperativo;
     @OneToMany(mappedBy = "servidor", cascade = CascadeType.ALL)
    @JsonIgnore // Ignorar la serialización de la lista de aplicaciones
    private List<aplicacion> aplicaciones = new ArrayList<>();
}
