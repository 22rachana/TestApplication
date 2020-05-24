package com.example.product.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import com.example.product.modal.Product;
import org.springframework.stereotype.Repository;
 
@Repository
public class ProductDao {
 
    private static final Map<String, Product> prodMap = new HashMap<String, Product>();
 
    static {
       initprods();
    }
 
    private static void initprods() {
        Product prod1 = new Product("E01", "ContainerBox", 50);
        Product prod2 = new Product("E02", "SprayBottle", 120);
        Product prod3 = new Product("E03", "Sanitizer", 600);
        Product prod4 = new Product("E04", "Shoes", 1000);

 
        prodMap.put(prod1.getprodNo(), prod1);
        prodMap.put(prod2.getprodNo(), prod2);
        prodMap.put(prod3.getprodNo(), prod3);
        prodMap.put(prod4.getprodNo(), prod4);
    }
 
    public Product getProduct(String prodNo) {
        return prodMap.get(prodNo);
    }
 
    public Product addProduct(Product prod) {
        prodMap.put(prod.getprodNo(), prod);
        return prod;
    }
 
    public Product updateProduct(Product prod) {
        prodMap.put(prod.getprodNo(), prod);
        return prod;
    }
 
    public void deleteProduct(String prodNo) {
        prodMap.remove(prodNo);
    }
 
    public List<Product> getAllProducts() {
        Collection<Product> c = prodMap.values();
        List<Product> list = new ArrayList<Product>();
        list.addAll(c);
        return list;
    }
 
}
