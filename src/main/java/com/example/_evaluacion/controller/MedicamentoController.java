/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example._evaluacion.controller;

import com.example._evaluacion.model.Medicamento;
import com.example._evaluacion.service.MedicamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Odalis
 */
@RestController
@RequestMapping("/api/medicamento")
public class MedicamentoController {
    @Autowired
    MedicamentoService medicamentoService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Medicamento>> listar(){
        return new ResponseEntity<>(medicamentoService.findByAll(),HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public String crear(@RequestBody Medicamento u){
        String mensaje="";
        String farmacia=u.getSucursal();
        String distri=u.getDistribuidor();
        
            if (u.getCantidad()>0) {
            if (u.getDistribuidor().equals("") || u.getSucursal().equals("") || u.getNombre().equals("") || u.getTipo().equals("") || String.valueOf(u.getCantidad()).equals("") ) {
                 mensaje="No pueden haber campos vacios, porfavor llene todos los datos";
            } else {
                if (farmacia.equalsIgnoreCase("PRINCIPAL") || farmacia.equalsIgnoreCase("SECUNDARIA")) {
                    if (distri.equalsIgnoreCase("COFARMA") || distri.equalsIgnoreCase("EMPSEPHAR") || distri.equalsIgnoreCase("CEMEFAR")  ) {
                        medicamentoService.crear(u);
                   String sucursal="";
                   if (u.getSucursal().equalsIgnoreCase("principal")) {
                   sucursal="Octavio Chacón Moscoso";   
                    
                } else {
                       sucursal="AV de la Independencia";
                }
                   mensaje="*PEDIDO ENVIADO CORRECTAMENTE*| Pedido al distribuidor "+u.getDistribuidor()+" | "+ u.getCantidad()+" unidades de "+u.getTipo()+" "+u.getNombre()+" | Para la farmacia situada en "+sucursal;
                    } else {
                        mensaje ="Distribuidor no reconocido";
                    }
                }else{
                    mensaje ="La sucursal debe ser entre PRINCIPAL Y SECUNDARIA";
                    
                }

            }
        } else {
            mensaje="La cantidad debe ser positiva y mayor a 0";
        }
        
        
        
    return mensaje;
}
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Medicamento> eliminar(@PathVariable  Long id){
        medicamentoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Medicamento> buscar(@PathVariable Long id){
        return new ResponseEntity<>(medicamentoService.findById(id),HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Medicamento> actualizar(@PathVariable Long id, @RequestBody Medicamento u){
        Medicamento medicamento = buscarusu(id); 
        if (medicamento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            medicamento.setCantidad(u.getCantidad());
            medicamento.setDistribuidor(u.getDistribuidor());
            medicamento.setNombre(u.getNombre());
            medicamento.setSucursal(u.getSucursal());
             medicamento.setTipo(u.getTipo());

            return new ResponseEntity<>(medicamentoService.crear(u),HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    public Medicamento buscarusu(Long id){
        return medicamentoService.findById(id);
    }
    
}
