package com.example.product.controller;

import java.util.List;

import com.example.product.dao.ProductDao;
import com.example.product.modal.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
 
public class MainRestController {
 
    @Autowired
    private ProductDao productDAO;
 
    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to Product details project";
    }
 
    // URL:
    // http://localhost:8084/productDetails
  
    @RequestMapping(value = "/productDetails", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Product> getproducts() {
        List<Product> list = productDAO.getAllProducts();
        return list;
    }
 
    // URL:
    // http://localhost:8084/product/{prodNo}
    //http://localhost:8084/product/E02
   
    @RequestMapping(value = "/product/{prodNo}",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Product getproduct(@PathVariable("prodNo") String prodNo) {
        return productDAO.getProduct(prodNo);
    }
 
    // URL:
    // http://localhost:8084/product/create
 
    @RequestMapping(value = "/product/create", method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Product addproduct(@RequestBody Product prod) {
 
        System.out.println("Creating product: " + prod.getprodNo());
 
        return productDAO.addProduct(prod);
    }
 
    // URL:
    // http://localhost:8084/product/edit
      
    @RequestMapping(value = "/product/edit",method = RequestMethod.PUT,produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Product updateproduct(@RequestBody Product prod) {
 
        System.out.println("Editing product: " + prod.getprodNo());
 
        return productDAO.updateProduct(prod);
    }
 
    // URL:
    // http://localhost:8084/product/delete/{prodNo}
    @RequestMapping(value = "/product/delete/{prodNo}",method = RequestMethod.DELETE,produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteproduct(@PathVariable("prodNo") String prodNo) {
 
        System.out.println("Deleting product: " + prodNo);
 
        productDAO.deleteProduct(prodNo);
        System.out.println("Deleted successfuly");
    }
 
}
