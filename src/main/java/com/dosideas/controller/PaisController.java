package com.dosideas.controller;

import com.dosideas.domain.Pais;
import com.dosideas.exception.PaisNoEncontradoException;
import com.dosideas.service.PaisService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @RequestMapping("/home")
    public String home(Map<String, Object> model) {
        model.put("paises", paisService.buscarTodos());
        return "pais";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Pais buscarPorId(@PathVariable Long id) throws PaisNoEncontradoException {
        Pais pais = paisService.buscarPorId(id);
        if (pais == null) {
            throw new PaisNoEncontradoException("Pais no encontrado");
        }
        return pais;
    }

}
