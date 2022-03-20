package com.ejmeplo.Springboot2.service;

import com.ejmeplo.Springboot2.model.Persona;
import java.util.List;

public interface IPersonaService {

    public List<Persona> verPersonas();

    public void crearPersona(Persona pers);

    public void borrarPersona(Long id);

    public Persona buscarPersona(Long id);

}
