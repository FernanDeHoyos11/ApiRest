/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest.ApiRest.controlador;


import com.ApiRest.ApiRest.Repositorio.IservidorRepo;
import com.ApiRest.ApiRest.Repositorio.especificacion.ServidorSpecifications;
import com.ApiRest.ApiRest.modelo.Servidor;
import java.util.List;
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
@RequestMapping("/servidores")
public class controladorServidor {
    
    @Autowired
    private IservidorRepo servidorRepo;
    
    @GetMapping("/hola")
    public String hola(){
        return "hola desde servidor";
    }
    
    @GetMapping("/lista")
    public List<Servidor> listarServidores() {
        return (List<Servidor>) servidorRepo.findAll();
    }

    @PostMapping("/guardar")
    public void guardarServidor(@RequestBody Servidor servidor) {
        servidorRepo.save(servidor);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarServidor(@PathVariable Long id) {
        servidorRepo.deleteById(id);
    }

    @GetMapping("/buscar/{id}")
    public Servidor buscarServidor(@PathVariable Long id) {
        return servidorRepo.findById(id).orElse(null);
    }
    
    @GetMapping("/con-mas-de-una-aplicacion")
    public List<Servidor> obtenerServidoresConMasDeUnaAplicacion() {
        Specification<Servidor> especificacion = ServidorSpecifications.servidoresConMasDeUnaAplicacion();
        return servidorRepo.findAll(especificacion);
    }

}
