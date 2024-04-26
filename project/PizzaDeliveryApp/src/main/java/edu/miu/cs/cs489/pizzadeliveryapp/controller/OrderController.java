package edu.miu.cs.cs489.pizzadeliveryapp.controller;

import edu.miu.cs.cs489.pizzadeliveryapp.dto.request.OrderRequest;
import edu.miu.cs.cs489.pizzadeliveryapp.dto.response.OrderResponse2;
import edu.miu.cs.cs489.pizzadeliveryapp.dto.response.PizzaOrderResponse;
import edu.miu.cs.cs489.pizzadeliveryapp.exception.CustomerNotFoundException;
import edu.miu.cs.cs489.pizzadeliveryapp.exception.OrderNotFoundException;
import edu.miu.cs.cs489.pizzadeliveryapp.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pizzamgm/api/v1/orders")
public class OrderController {

    private OrderService orderService;
    public OrderController(OrderService orderService) {this.orderService = orderService;}

    @GetMapping
    public ResponseEntity<List<OrderResponse2>> listOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse2> getOrderById(@PathVariable Long orderId) throws OrderNotFoundException {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderResponse2>> getOrderByCustomerId(@PathVariable Integer customerId) throws CustomerNotFoundException {
        return ResponseEntity.ok(orderService.getOrderByCustomerId(customerId));
    }

    @PostMapping("/new/{customerId}")
    public ResponseEntity<OrderResponse2> addNewOrder(@PathVariable Integer customerId, @RequestBody @Valid OrderRequest orderRequest) throws CustomerNotFoundException {
        return new ResponseEntity<>(orderService.addOrderByCustomerId(customerId, orderRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<OrderResponse2> updateOrderById(@PathVariable Long orderId, @RequestBody @Valid OrderRequest orderRequest) throws OrderNotFoundException {
        return new ResponseEntity<>(orderService.updateOrderById(orderId, orderRequest), HttpStatus.OK);
    }

    @PutMapping("/update/status/{orderId}")
    public ResponseEntity<OrderResponse2> updateOrderStatusById(@PathVariable Long orderId, @RequestBody @Valid OrderRequest orderRequest) throws OrderNotFoundException {
        return new ResponseEntity<>(orderService.updateOrderStatusById(orderId, orderRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long orderId){
        orderService.deleteOrderById(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/pizzas")
    public ResponseEntity<List<PizzaOrderResponse>> getPizzasByDate(
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate endDate) {
        return ResponseEntity.ok(orderService.getOrderByDate(startDate, endDate));
    }
}
