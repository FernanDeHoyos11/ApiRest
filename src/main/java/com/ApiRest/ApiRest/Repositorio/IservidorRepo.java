/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ApiRest.ApiRest.Repositorio;



import com.ApiRest.ApiRest.modelo.Servidor;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fernan
 */
//CrudRepository<entidad que manejara, tipo de id de la tabla o entidad>
public interface IservidorRepo  extends CrudRepository<Servidor, Long>{
    
}
