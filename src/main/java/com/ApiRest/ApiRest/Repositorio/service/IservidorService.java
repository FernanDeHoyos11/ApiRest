/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ApiRest.ApiRest.Repositorio.service;


import com.ApiRest.ApiRest.modelo.Servidor;
import java.util.List;

/**
 *
 * @author fernan
 */
public interface IservidorService {
     
    public List<Servidor> ListarServidor();
    public void guardar(Servidor servidor);
    public void eliminar(Servidor servidor);
    public Servidor BuscarServidor(Long id);
    

}
