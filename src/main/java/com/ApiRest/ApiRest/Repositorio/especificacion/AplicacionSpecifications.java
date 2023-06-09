/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest.ApiRest.Repositorio.especificacion;

import com.ApiRest.ApiRest.modelo.Servidor;
import com.ApiRest.ApiRest.modelo.Servidor_;
import com.ApiRest.ApiRest.modelo.aplicacion;
import com.ApiRest.ApiRest.modelo.aplicacion_;
import javax.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author fernan
 */
public class AplicacionSpecifications {
    
//    SELECT * FROM aplicacion
//JOIN servidor ON aplicacion.servidor_id = servidor.id
//WHERE servidor.sistema_operativo = 'valor_sistema_operativo';

     public static Specification<aplicacion> porSistemaOperativo(String sistemaOperativo) {
        return (root, query, criteriaBuilder) -> {
            Join<aplicacion, Servidor> servidorJoin = root.join(aplicacion_.servidor);
            return criteriaBuilder.equal(servidorJoin.get(Servidor_.sistemaOperativo), sistemaOperativo);
        };
    }
     
     //    SELECT * FROM aplicacion WHERE nombre = 'valor_nombre';
      public static Specification<aplicacion> porNombre(String nombre) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(aplicacion_.nombre), nombre);
        };
    }
}
