/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest.ApiRest.controlador;


import com.ApiRest.ApiRest.Repositorio.service.IservidorService;
import com.ApiRest.ApiRest.modelo.Servidor;
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
@RequestMapping("/servidores")
public class controladorServidor {
    
    @Autowired
    private IservidorService servidorService;
    
    @GetMapping("/hola")
    public String hola(){
        return "hola desde servidor";
    }
    
    @GetMapping("/lista")
    public List<Servidor> listarServidores() {
        return servidorService.ListarServidor();
    }

    @PostMapping("/guardar")
    public void guardarServidor(@RequestBody Servidor servidor) {
        servidorService.guardar(servidor);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarServidor(@PathVariable Long id) {
        Servidor servidor = servidorService.BuscarServidor(id);
        if (servidor != null) {
            servidorService.eliminar(servidor);
        }
    }

    @GetMapping("/buscar/{id}")
    public Servidor buscarServidor(@PathVariable Long id) {
        return servidorService.BuscarServidor(id);
    }

}
