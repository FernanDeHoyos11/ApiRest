/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest.ApiRest.controlador;

import com.ApiRest.ApiRest.Repositorio.service.IaplicacionService;
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
    private IaplicacionService aplicacionService;
    
    @GetMapping("/hola")
    public String hola(){
        return "hola desde aplicacion";
    }
    
    @GetMapping("/lista")
    public List<aplicacion> listarAplicaciones() {
        return aplicacionService.ListarAplicaciones();
    }

    @PostMapping("/guardar")
    public void guardarAplicacion(@RequestBody aplicacion aplicacion) {
        aplicacionService.guardar(aplicacion);
    }

    @DeleteMapping("/{id}")
    public void eliminarAplicacion(@PathVariable Long id) {
        aplicacion aplicacion = aplicacionService.BuscarAplicacion(id);
        if (aplicacion != null) {
            aplicacionService.eliminar(aplicacion);
        }
    }

    @GetMapping("/{id}")
    public aplicacion buscarAplicacion(@PathVariable Long id) {
        return aplicacionService.BuscarAplicacion(id);
    }
    
}
