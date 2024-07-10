package com.dosideas.service;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProvinciaService {
    
    private final ProvinciaRepository provinciaRepository;


    @Autowired
    public ProvinciaService(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }


    public Provincia buscarPorId(Long id) {
        if (id == null) {
            return null;
        }
        return provinciaRepository.findById(id).orElse(null);    
    }
    
    public List<Provincia> buscarPorNombreExacto(String nombre) throws IllegalArgumentException{
        
        if(nombre == null) {
            throw new IllegalArgumentException("El nombre es nulo.");
        } else if (nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre tiene menos de 3 caracteres.");
        }
        
        return provinciaRepository.findByNombre(nombre);                    
    }
    
    public List<Provincia> buscarPorNombreGeneral(String parteDelNombre) throws IllegalArgumentException{
         if(parteDelNombre == null) {
            throw new IllegalArgumentException("El texto enviado es nulo");
        }
                           
         return provinciaRepository.findByNombreContainingIgnoreCase(parteDelNombre);
         
    }
    
    public Provincia guardarProvincia(Provincia nuevaProvincia) throws IllegalArgumentException {
        if(nuevaProvincia == null) {
            throw new IllegalArgumentException("La provincia es nula");
        } else if (nuevaProvincia.getNombre() == null || nuevaProvincia.getNombre().length() <= 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres");
        }
        
       /**
        * Seteo el id a nulo para evitar que envien
        * algun id definido y dejar que la db defina un id nuevo
        */
        nuevaProvincia.setId(null);
        
        return provinciaRepository.save(nuevaProvincia);
    }
    
    public List<Provincia> buscarTodas () {
        return provinciaRepository.findAll();
    }

   
    
}
