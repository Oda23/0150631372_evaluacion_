/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example._evaluacion.service;

import com.example._evaluacion.model.Medicamento;
import java.util.List;

/**
 *
 * @author Odalis
 */
public interface MedicamentoService {

    public Medicamento crear(Medicamento p);

    public Medicamento findById(Long id);

    public List<Medicamento> findByAll();

    public void delete(Long id);
}
