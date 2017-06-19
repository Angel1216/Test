package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Libro;

import mx.com.anzen.repository.SPRepository;
import mx.com.anzen.bean.ParametrosSP;




@Service
public class ServiceBookImpl implements ServiceBook{
	
	@Autowired
	private SPRepository spService;

	@Override
	public List<Libro> getBook(int id) {
		
	// Nombre SP
	String nombreSP = "spQueryBook";
			
	// Parametros SP
	List<ParametrosSP> lstParametrosSP = new ArrayList<ParametrosSP>();
	ParametrosSP pId = new ParametrosSP(1,"id",id);
	lstParametrosSP.add(pId);
	
	@SuppressWarnings("unchecked")
	List<Libro> lstBook = (List<Libro>) spService.getQuerySP(nombreSP, lstParametrosSP);
	return lstBook;
		
	}

	
	@Override
	public Object getCRUDSP(String nombreSP, List<ParametrosSP> lstParametrosSP) {
		
		// Invocar SP para insert, update y delete
		return spService.getCRUDSP(nombreSP, lstParametrosSP);
	}


}
