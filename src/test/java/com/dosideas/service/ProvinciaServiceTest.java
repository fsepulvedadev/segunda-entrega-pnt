package com.dosideas.service;

import com.dosideas.domain.Provincia;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProvinciaServiceTest {
    
    @Autowired 
    private ProvinciaService provinciaService;

    @Test
    public void buscarPorId_conIdExistente_retornaProvincia() {
        
        Long id = 1L;

        Provincia provincia = provinciaService.buscarPorId(id);

        assertThat(provincia).isNotNull();
        assertThat(provincia.getId()).isEqualTo(id);
  }
    
    @Test
    public void buscarPorId_conIdInexistente_retornaNull() {
        
        Long id = 123123L;

        Provincia provincia = provinciaService.buscarPorId(id);

        assertThat(provincia).isNull();
  }
    
    @Test
    public void buscarPorId_conIdNull_retornaNull() {
        
        Long id = null;

        Provincia provincia = provinciaService.buscarPorId(id);

        assertThat(provincia).isNull();
  }
    
    
    @Test
    public void buscarPorNombreExacto_conStringValido_retornaListaProvincia() {
        
        String nombre = "Cordoba";

        List<Provincia> provincias = provinciaService.buscarPorNombreExacto(nombre);

        assertThat(provincias).isNotNull();
  }
    
    @Test
    public void buscarPorNombreExacto_conStringNull_retornaIllegalArgumentException() {
        
        String nombre = null;

          assertThatExceptionOfType(IllegalArgumentException.class)
                  .isThrownBy(() -> { provinciaService.buscarPorNombreExacto(nombre); })
                  .withMessage("El nombre es nulo.");
    }
                                                     
    @Test
    public void buscarPorNombreExacto_conStringMuyCorto_retornaIllegalArgumentException() {
        
        String nombre = "Co";

        assertThatExceptionOfType(IllegalArgumentException.class)
                  .isThrownBy(() -> { provinciaService.buscarPorNombreExacto(nombre); })
                  .withMessage("El nombre tiene menos de 3 caracteres.");           
  }
    
       
    @Test
    public void buscarPorNombreGeneral_conStringNulo_retornaIllegalArgumentException() {
        
        String parteDelNombre = null;

        assertThatExceptionOfType(IllegalArgumentException.class)
                  .isThrownBy(() -> { provinciaService.buscarPorNombreGeneral(parteDelNombre); })
                  .withMessage("El texto enviado es nulo");             
  }
    
    @Test
    public void buscarPorNombreGeneral_conStringValido_retornaListaDeProvinciasConParteDelString() {
        
        String parteDelNombre = "Es";
        
        List<Provincia> provincias = provinciaService.buscarPorNombreGeneral(parteDelNombre);
        
         System.out.println(provincias);
    /**
     * Testeamos que todos los elementos que devuelve el metodo buscarPorNombreGeneral
     * contengan el string pasado por parametro.
     */
        assertThat(provincias)
                .isNotEmpty()
                .isNotNull()
                .extracting(Provincia::getNombre)
                .allSatisfy(nombre -> assertThat(nombre.toLowerCase()).contains(parteDelNombre.toLowerCase()));                              
  }
    
    @Test
    public void guardarProvincia_conProvinciaValida_retornaLaProvinciaGuardada() {
        
        Provincia nuevaProvincia = new Provincia(null,"Nueva Provincia", 1L);
        
        Provincia provinciaGuardada = provinciaService.guardarProvincia(nuevaProvincia);
        
        assertThat(provinciaGuardada)
                .extracting(Provincia::getId)
                 .isNotNull();
        
         assertThat(provinciaGuardada)
                .extracting(Provincia::getNombre)
                 .isNotNull();
         
          assertThat(provinciaGuardada)
                .extracting(Provincia::getIdPais)
                 .isNotNull();                                         
  }

    @Test
    public void guardarProvincia_conProvinciaNull_retornaIllegalArgumentException() {
        
        Provincia nuevaProvincia = null;
        
        assertThatExceptionOfType(IllegalArgumentException.class)
                  .isThrownBy(() -> { provinciaService.guardarProvincia(nuevaProvincia); });
        
    } 

    @Test
    public void guardarProvincia_conNombreDeProvinciaNull_retornaIllegalArgumentException() {
        
        Provincia nuevaProvincia = new Provincia(null,null, 1L); 
        
        assertThatExceptionOfType(IllegalArgumentException.class)
                  .isThrownBy(() -> { provinciaService.guardarProvincia(nuevaProvincia); });
        
    }

    @Test
    public void guardarProvincia_conNombreDeProvinciaCorto_retornaIllegalArgumentException() {
        
        Provincia nuevaProvincia = new Provincia(null,"Te", 1L); 
        
        assertThatExceptionOfType(IllegalArgumentException.class)
                  .isThrownBy(() -> { provinciaService.guardarProvincia(nuevaProvincia); });
        
    }




















} 











  
    
