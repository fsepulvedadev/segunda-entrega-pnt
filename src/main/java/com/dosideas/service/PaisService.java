/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.service;

import com.dosideas.domain.Pais;
import java.util.List;

/**
 *
 * @author ldeseta
 */
public interface PaisService {

    Pais buscarPorId(Long id);
    
    List<Pais> buscasTodos();

}
