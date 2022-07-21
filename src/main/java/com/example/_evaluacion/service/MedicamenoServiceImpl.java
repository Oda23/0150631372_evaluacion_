/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example._evaluacion.service;

import com.example._evaluacion.model.Medicamento;
import com.example._evaluacion.repository.MedicamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Odalis
 */
@Service
public class MedicamenoServiceImpl implements MedicamentoService{
    @Autowired
    public MedicamentoRepository medicamentorepository;

    @Override
    public Medicamento crear(Medicamento p) {
        return medicamentorepository.save(p);
    }

    @Override
    public Medicamento findById(Long id) {
        return medicamentorepository.findById(id).orElse(null);
    }

    @Override
    public List<Medicamento> findByAll() {
        return medicamentorepository.findAll();
    }

    @Override
    public void delete(Long id) {
        medicamentorepository.deleteById(id);
    }
    
}
