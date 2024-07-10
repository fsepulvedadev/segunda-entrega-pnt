package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{
    
    List<Provincia> findByNombre(String nombre);
    
    List<Provincia> findByNombreContainingIgnoreCase(String parteDelNombre);
    
}
