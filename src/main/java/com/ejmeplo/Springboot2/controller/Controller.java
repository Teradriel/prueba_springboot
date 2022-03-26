package com.ejmeplo.Springboot2.controller;

import com.ejmeplo.Springboot2.model.Persona;
import com.ejmeplo.Springboot2.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private IPersonaService persoServ;

    @PostMapping("/new/persona")
    public void agregarPersona(@RequestBody Persona pers) {
        persoServ.editarPersona(pers);
    }

    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas() {
        return persoServ.verPersonas();
    }

    @DeleteMapping("delete/{id}")
    public String borrarPersona(@PathVariable Long id) {
        persoServ.borrarPersona(id);
        return persoServ.buscarPersona(id).getNombre() + " " + persoServ.buscarPersona(id).getApellido() + " ya no se encuentra en la base de datos";
    }
    
    @PutMapping("edit/{id}")
    public String editarPersona(@PathVariable Long id, @RequestParam ("nombre") String nuevo_nombre, @RequestParam ("apellido") String nuevo_apellido, @RequestParam("edad") int nueva_edad){
        Persona perso = persoServ.buscarPersona(id);
        
        perso.setNombre(nuevo_nombre);
        perso.setApellido(nuevo_apellido);
        perso.setEdad(nueva_edad);
        
        persoServ.editarPersona(perso);
        
        return perso.getNombre() + " cambiado correctamente";
    }   

}
