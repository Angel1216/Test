package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Libro;
import com.example.service.ServiceBook;

import mx.com.anzen.bean.ParametrosSP;


/**
 * 
 * @author: Angel
 * @version: 1.0 (22/02/17) 
 */
@RestController
public class Controller {

		// Inyeccion de dependencias del servicio
		@Autowired
		private ServiceBook service;

		
		// Invoke a Stored Procedure (Consultas)  
		@RequestMapping(value = "/JPA/SP/Query/testApiSP/{id}")
		public List<Libro> getQueryBookSP(@PathVariable int id) {
			return service.getBook(id);
		}
		
		
		
		
		// Invoke a Stored Procedure (Insercion, actualizacion y eliminacion de datos)
		@RequestMapping(value = "/JPA/SP/CRUD/testApiSP/{id}/{autor}/{name}")
		public String getCreateBookSP(@PathVariable int id, @PathVariable String autor, @PathVariable String name) {
			
			// Variables y Constantes
			final int EXITOSO = 0;
			
			// Nombre SP
			String nombreSP = "spInsertBook";
					
			// Parametros SP
			List<ParametrosSP> lstParametrosSP = new ArrayList<ParametrosSP>();
			ParametrosSP pId = new ParametrosSP(1,"id",id);
			ParametrosSP pAuthor = new ParametrosSP(3,"author",autor);
			ParametrosSP pName = new ParametrosSP(3,"name",name);
			lstParametrosSP.add(pId);
			lstParametrosSP.add(pAuthor);
			lstParametrosSP.add(pName);
			
			@SuppressWarnings("unchecked")
			Vector<Object> response = (Vector<Object>)service.getCRUDSP(nombreSP, lstParametrosSP);
					
			// Validar repsuesta
			if((Integer)response.get(0)==EXITOSO){
				return "Exitoso";
			} else {
				return (String)response.get(1);
			}
			
		}
		
}
