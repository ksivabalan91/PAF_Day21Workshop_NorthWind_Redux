package paf.week1.day21workshopnorthwindredux.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.week1.day21workshopnorthwindredux.models.Customer;
import paf.week1.day21workshopnorthwindredux.models.Order;
import paf.week1.day21workshopnorthwindredux.repositories.NorthwindRepository;

@Service
public class NorthwindServices {

    @Autowired
    private NorthwindRepository nwRepo;

    public List<Customer> getAllCustomers(int offset, int limit){
        return nwRepo.findItems("*", "customers", "limit "+limit+" offset "+offset, Customer.class);
    }

    public Customer getCustomerById(int id) {
        try{
            return nwRepo.findItemBy("*", "customers", "id", String.valueOf(id), Customer.class).get(0);
        }catch(Exception ex){
            return null;
        }
    }
    
    public List<Order> findOrdersByCustomer(int id) {
        try{
            return nwRepo.findItemBy("*", "orders", "customer_id", String.valueOf(id), Order.class);
        }catch(Exception ex){
            return null;            
        }
    }
    
}
