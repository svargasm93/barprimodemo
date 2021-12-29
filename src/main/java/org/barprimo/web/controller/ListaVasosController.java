package org.barprimo.web.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.barprimo.domain.service.ListaVasosService;
import org.barprimo.persistance.entity.ListaVasos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/listavasos")
public class ListaVasosController {
	
	@Autowired
	private ListaVasosService listaVasosService;
	
	@GetMapping("/{id}")
	@ApiOperation("Obtiene la lista de vasos del id suministrado")
	@ApiResponse(code = 200, message = "OK")
	public ResponseEntity<ListaVasos> getById(@ApiParam(value = "El id de la lista de vasos (1-5)",
            required = true, example = "2") @PathVariable("id")  int id){
		return listaVasosService.getById(id).map(listavasos -> new ResponseEntity<>(listavasos,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/{id}/{it}")
	@ApiOperation("Obtiene el resultado de iterar la lista de vasos")
	public ResponseEntity<List<Integer>> getResultado(@ApiParam(value = "El id de la lista de vasos (1-5)",
            required = true, example = "2") @PathVariable("id")  int id, @ApiParam(value = "El número de iteraciones que realizará",
            required = true, example = "3") @PathVariable("it") int it){
							
		return new ResponseEntity<>(listaVasosService.getResultado(id, it),HttpStatus.OK);
	}
	
		
		
		
}
