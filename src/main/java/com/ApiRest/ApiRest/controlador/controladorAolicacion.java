/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest.ApiRest.controlador;

import com.ApiRest.ApiRest.Repositorio.IaplicacionRepo;
import com.ApiRest.ApiRest.Repositorio.especificacion.AplicacionSpecifications;
import com.ApiRest.ApiRest.modelo.Servidor;
import com.ApiRest.ApiRest.modelo.Servidor_;
import com.ApiRest.ApiRest.modelo.aplicacion;
import com.ApiRest.ApiRest.modelo.aplicacion_;
import java.util.List;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fernan
 */
@RestController
@RequestMapping("/aplicaciones")
public class controladorAolicacion {

    @Autowired
    private IaplicacionRepo aplicacionRepo;

   

    @GetMapping("/hola")
    public String hola() {
        return "hola desde aplicacion";
    }

    @GetMapping("/lista")
    public List<aplicacion> listarAplicaciones() {
        return (List<aplicacion>) aplicacionRepo.findAll();
    }

    @PostMapping("/guardar")
    public void guardarAplicacion(@RequestBody aplicacion aplicacion) {
        aplicacionRepo.save(aplicacion);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarAplicacion(@PathVariable Long id) {
        aplicacionRepo.deleteById(id);
    }

    @GetMapping("/buscar/{id}")
    public aplicacion buscarAplicacion(@PathVariable Long id) {
        return aplicacionRepo.findById(id).orElse(null);
    }

//    @GetMapping("/servidor/so/{SistemaOperativo}")
//    public List<aplicacion> getAplicacionesPorSistemaOperativo(@PathVariable String SistemaOperativo) {
//        Specification<aplicacion> spec = (root, query, criteriaBuilder) -> {
//            Join<aplicacion, Servidor> servidorJoin = root.join(aplicacion_.servidor);
//            Predicate sistemaOperativoPredicate = criteriaBuilder.equal(servidorJoin.get(Servidor_.sistemaOperativo), SistemaOperativo);
//            return sistemaOperativoPredicate;
//        };
//        return aplicacionRepo.findAll(spec);
//    }

    @GetMapping("/servidor/so/{sistemaOperativo}")
    public List<aplicacion> getAplicacionesPorSistemaOperativo(@PathVariable String sistemaOperativo) {
        Specification<aplicacion> spec = AplicacionSpecifications.porSistemaOperativo(sistemaOperativo);
        return aplicacionRepo.findAll(spec);
    }
//    @GetMapping("/aplicacion/{nombre}")
//public List<aplicacion> getAplicacionesPorNombre(@PathVariable String nombre) {
//    Specification<aplicacion> spec = (root, query, criteriaBuilder) -> {
//        Predicate nombrePredicate = criteriaBuilder.equal(root.get(aplicacion_.nombre), nombre);
//        return nombrePredicate;
//    };
//    return aplicacionRepo.findAll(spec);
//}
    
     @GetMapping("/aplicacion/{nombre}")
    public List<aplicacion> getAplicacionesPorNombre(@PathVariable String nombre) {
        Specification<aplicacion> spec = AplicacionSpecifications.porNombre(nombre);
        return aplicacionRepo.findAll(spec);
    }



}
