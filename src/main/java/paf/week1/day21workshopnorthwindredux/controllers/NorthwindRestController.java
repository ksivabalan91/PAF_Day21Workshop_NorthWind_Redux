package paf.week1.day21workshopnorthwindredux.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import paf.week1.day21workshopnorthwindredux.Utils;
import paf.week1.day21workshopnorthwindredux.models.Customer;
import paf.week1.day21workshopnorthwindredux.models.Order;
import paf.week1.day21workshopnorthwindredux.services.NorthwindServices;

@Controller
@RequestMapping("/api")
public class NorthwindRestController {
    @Autowired
    private NorthwindServices nwSvc;

    @GetMapping(path="/customers", produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<String> getAllCustomers(@RequestParam(name="offset",defaultValue="0") int offset, @RequestParam(name = "limit", defaultValue = "5") int limit){
        List<Customer> customers = nwSvc.getAllCustomers(offset, limit);
        
        if(!customers.isEmpty()){
            JsonArray jsonArr = Utils.toJsonArray(customers);
            return ResponseEntity.ok().body(jsonArr.toString());
        } else{
            return ResponseEntity.badRequest().body("not found");
        }
    }

    @GetMapping(path="/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCustomerByID(@PathVariable("id") int id){
        
        Customer customer = nwSvc.getCustomerById(id);
        if(null!=customer){
            JsonObject jsonObject = Utils.toJsonObject(customer);
            return ResponseEntity.ok().body(jsonObject.toString());
        }else{
            return ResponseEntity.status(404).body("Customer not found");
        }
    }

    @GetMapping(path="/customer/{id}/orders", produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<String> getAllCustomers(@PathVariable("id") int id){
        List<Order> orders = nwSvc.findOrdersByCustomer(id);

        if(!orders.isEmpty()){
            JsonArray jsonArr = Utils.toJsonArray(orders);
            return ResponseEntity.ok().body(jsonArr.toString());
        }else{
            return ResponseEntity.badRequest().body("No orders found for this customer");
        }
    }

    
}
