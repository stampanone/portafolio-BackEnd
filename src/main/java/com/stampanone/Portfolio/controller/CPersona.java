package com.stampanone.Portfolio.controller;

import com.stampanone.Portfolio.entity.Persona;
import com.stampanone.Portfolio.service.SPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
@CrossOrigin(origins = "http://localhost:4200")
public class CPersona {
    
    @Autowired
    SPersona persoServ;
    
    @GetMapping("/lista")
    @ResponseBody
    public List<Persona> verPersona(){
        return persoServ.verPersonas();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Persona verPersona(@PathVariable int id){
        return persoServ.buscarPersona(id);
    }
    
    @PostMapping("/crear")
    public String agregarPersona (@RequestBody Persona pers){
        persoServ.crearPersona(pers);
        return "La persona fue creada correctamente.";
    }
    
    @DeleteMapping("/borrar/{id}")
    public String eliminarPersona(@PathVariable int id){
        persoServ.borrarPersona(id);
        return "La persona fue eliminada correctamente.";
    }
    
    @PutMapping("/editar")
    public String editarPersona (@RequestBody Persona pers){
        persoServ.editarPersona(pers);
        return "La persona fue editada.";
    }
    
    
}
