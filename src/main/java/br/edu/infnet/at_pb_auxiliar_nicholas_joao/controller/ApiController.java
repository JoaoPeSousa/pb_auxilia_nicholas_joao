/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.at_pb_auxiliar_nicholas_joao.controller;

import br.edu.infnet.at_pb_auxiliar_nicholas_joao.entity.Serie;
import br.edu.infnet.at_pb_auxiliar_nicholas_joao.repositories.SerieRepository;
import java.util.Optional;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nicholas
 */
@RestController
public class ApiController {
    
    @Autowired 
    private SerieRepository seriesRepo;
    
    @GetMapping(path = "/rest/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Serie> getAll(){
        return seriesRepo.findAll();
    }
    
    @GetMapping(path = "/rest/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Serie> getById(@PathVariable("id") Long id){
           return seriesRepo.findById(id);
    }
    
    @DeleteMapping("/rest/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
            seriesRepo.deleteById(id);
            return ResponseEntity.ok("Deleted");
    }
    
    @PostMapping("/rest/insert")
    public Serie insertInto(@RequestBody Serie serie){
            seriesRepo.save(serie);
            return serie;
    }
    
    @PostMapping("/rest/update/{id}")
    public Serie updateById(@PathVariable("id") Long id, @RequestBody Serie serie){
            Optional<Serie> update = seriesRepo.findById(id);
            if(update.isPresent()){
                update.get().setName(serie.getName());
                update.get().setDescription(serie.getDescription());
                update.get().setImage(serie.getImage());
                seriesRepo.save(update.get());
                return update.get();
            }
            return serie;
    }
}
