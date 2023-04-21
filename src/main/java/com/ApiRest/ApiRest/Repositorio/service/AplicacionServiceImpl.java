/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest.ApiRest.Repositorio.service;


import com.ApiRest.ApiRest.Repositorio.IaplicacionRepo;
import com.ApiRest.ApiRest.modelo.aplicacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fernan
 */
@Service
public class AplicacionServiceImpl implements IaplicacionService{
    
    @Autowired
    private IaplicacionRepo aplicacionRepo;

    @Override
    @Transactional(readOnly = true)// como solo se leera informacion importamos esta notacion
    // de spring y no de java
    public List<aplicacion> ListarAplicaciones() {
         return (List<aplicacion>) aplicacionRepo.findAll();
    }

    @Override
    @Transactional //aqui la dejanmos sin el readOnly porque se hara commit o rollBack
    public void guardar(aplicacion apli) {
        aplicacionRepo.save(apli);
    }

    @Override
    public void eliminar(aplicacion apli) {
        aplicacionRepo.delete(apli);
    }

    @Override
    public aplicacion BuscarAplicacion(Long id) {
        return aplicacionRepo.findById(id).orElse(null);
    }
}
