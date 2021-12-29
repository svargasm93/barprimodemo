package org.barprimo.domain.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ListaVasosService {
	
	@Autowired
	private org.barprimo.domain.repository.ListCupsRepository listCupsRepository;
	
	public Optional<org.barprimo.persistance.entity.ListaVasos> getById(int id) {
		// TODO Auto-generated method stub
		return listCupsRepository.getById(id);
	}
	
	public List<Integer> getResultado(int id, int it){
		
		List<Integer> Resultado = new ArrayList<Integer>();
		Resultado = calcularResultado(this.getById(id).get().getInputArray(),it);
		
		return Resultado;
	}
	
	
	public List<Integer> calcularResultado(String Lista, int iteraciones){
		
		Pattern pattern = Pattern.compile(",");
		List<Integer> Vasos = pattern.splitAsStream(Lista)
		                            .map(Integer::valueOf)
		                            .collect(Collectors.toList());
		
		List<Integer> numerosPrimos = listaPrimos(iteraciones);
		
		List<Integer> Respuesta = new ArrayList<>();
		List<Integer> A;
		List<Integer> B;
		
				
		for(int i=0; i<iteraciones;i++) {
			B = new ArrayList<>();
			A = new ArrayList<>();
			for(int j=Vasos.size()-1; j>=0;j--) {
				if (Vasos.get(j)%numerosPrimos.get(i)==0) {
					B.add(Vasos.get(j));
				}else {
					A.add(Vasos.get(j));
				}
			}
			Respuesta.addAll(B);
			
			if(i+1<iteraciones) {
				Vasos = A;	
			} else {
				Respuesta.addAll(A);
			}
		}
		
		
		
		
		return Respuesta;
	}
			
	public static List<Integer> listaPrimos(int n) {
	    
	    List<Integer> numerosPrimos = new LinkedList<>();
	    
	      int estado = 1;
	      int num = 3;
	      if (n >= 1)
	      {
	    	  numerosPrimos.add(2);
	      }

	      for ( int i = 2 ; i <=n ;  )
	      {
	         for ( int j = 2 ; j <= Math.sqrt(num) ; j++ )
	         {
	            if ( num%j == 0 )
	            {
	            	estado = 0;
	               break;
	            }
	         }
	         if ( estado != 0 )
	         {
	        	 numerosPrimos.add(num);
	            i++;
	         }
	         estado = 1;
	         num++;
	      }         
	    return numerosPrimos;
	}

}
