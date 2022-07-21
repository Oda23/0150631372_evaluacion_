/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example._evaluacion.repository;

import com.example._evaluacion.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Odalis
 */
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{
    
}
