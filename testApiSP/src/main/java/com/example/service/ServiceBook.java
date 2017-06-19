package com.example.service;

import java.util.List;

import com.example.bean.Libro;

import mx.com.anzen.bean.ParametrosSP;


/**
 * 
 * @author: Angel
 * @category: Persistencia
 * @version: 1.0 (22/02/17) 
 */
public interface ServiceBook {

	// Metood para retornar la ocnsulta de un libro por ID
	public List<Libro> getBook(int id);
	
	
	public Object getCRUDSP(String nombreSP, List<ParametrosSP> lstParametrosSP);
	
}
