/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest.ApiRest.controlador;

import com.ApiRest.ApiRest.Repositorio.IaplicacionRepo;
import com.ApiRest.ApiRest.modelo.aplicacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String hola(){
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
    
}
