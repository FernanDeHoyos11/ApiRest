/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest.ApiRest.Repositorio.especificacion;

import com.ApiRest.ApiRest.modelo.Servidor;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author fernan
 */
public class ServidorSpecifications {
    public static Specification<Servidor> servidoresConMasDeUnaAplicacion() {
        return new Specification<Servidor>() {
            @Override
            public Predicate toPredicate(Root<Servidor> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<Object, Object> joinAplicaciones = root.join("aplicaciones");
                query.groupBy(root.get("id"));
                query.having(criteriaBuilder.gt(criteriaBuilder.count(joinAplicaciones), 1L));
                return criteriaBuilder.conjunction();
            }
        };
    }
}
