/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ApiRest.ApiRest.Repositorio.service;


import com.ApiRest.ApiRest.modelo.aplicacion;
import java.util.List;

/**
 *
 * @author fernan
 */
public interface IaplicacionService {
     
    public List<aplicacion> ListarAplicaciones();
    public void guardar(aplicacion apli);
    public void eliminar(aplicacion apli);
    public aplicacion BuscarAplicacion(Long id);
    
}
