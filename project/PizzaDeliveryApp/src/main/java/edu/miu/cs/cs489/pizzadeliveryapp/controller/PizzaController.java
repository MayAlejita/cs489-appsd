package edu.miu.cs.cs489.pizzadeliveryapp.controller;

import edu.miu.cs.cs489.pizzadeliveryapp.dto.request.PizzaRequest;
import edu.miu.cs.cs489.pizzadeliveryapp.dto.response.PizzaResponse2;
import edu.miu.cs.cs489.pizzadeliveryapp.exception.PizzaNotFoundException;
import edu.miu.cs.cs489.pizzadeliveryapp.service.PizzaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzamgm/api/v1/pizzas")
public class PizzaController {

    private PizzaService pizzaService;
    public PizzaController(PizzaService pizzaService) {this.pizzaService = pizzaService;}

    @GetMapping
    public ResponseEntity<List<PizzaResponse2>> listPizzas(){
        return ResponseEntity.ok(pizzaService.getAllPizzas());
    }

    @GetMapping("/{pizzaId}")
    public ResponseEntity<PizzaResponse2> getPizzaById(@PathVariable Integer pizzaId) throws PizzaNotFoundException {
        return ResponseEntity.ok(pizzaService.getPizzaById(pizzaId));
    }

    @PostMapping("/new")
    public ResponseEntity<PizzaResponse2> addNewPizza(@RequestBody @Valid PizzaRequest pizzaRequest){
        return new ResponseEntity<>(pizzaService.addPizza(pizzaRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{pizzaId}")
    public ResponseEntity<PizzaResponse2> updatePizzaById(@PathVariable Integer pizzaId, @RequestBody @Valid PizzaRequest pizzaRequest) throws PizzaNotFoundException {
        return new ResponseEntity<>(pizzaService.updatePizzaById(pizzaId, pizzaRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{pizzaId}")
    public ResponseEntity<Void> deletePizzaById(@PathVariable Integer pizzaId){
        pizzaService.deletePizzaById(pizzaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
