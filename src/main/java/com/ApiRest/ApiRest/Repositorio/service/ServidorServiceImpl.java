/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest.ApiRest.Repositorio.service;


import com.ApiRest.ApiRest.Repositorio.IservidorRepo;
import com.ApiRest.ApiRest.modelo.Servidor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fernan
 */
@Service // para inyectar IservidorService dentro del controlador
public class ServidorServiceImpl implements IservidorService{
    @Autowired
    private IservidorRepo servidorRepo;
    
    @Override
    @Transactional(readOnly = true)// como solo se leera informacion importamos esta notacion
    // de spring y no de java
    public List<Servidor> ListarServidor() {
        return (List<Servidor>) servidorRepo.findAll();
         }

    @Override
    @Transactional //aqui la dejanmos sin el readOnly porque se hara commit o rollBack
    public void guardar(Servidor servidor) {
        servidorRepo.save(servidor);
         }

    @Override
    @Transactional //aqui la dejanmos sin el readOnly porque se hara commit o rollBack
    public void eliminar(Servidor servidor) {
        servidorRepo.delete(servidor);
          }

    @Override
    @Transactional(readOnly = true)
    public Servidor BuscarServidor(Long id) {
        return servidorRepo.findById(id).orElse(null);
          }
}
