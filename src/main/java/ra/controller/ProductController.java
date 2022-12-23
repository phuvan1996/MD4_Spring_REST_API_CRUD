package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Catalog;
import ra.model.entity.Product;
import ra.model.service.CatalogService;
import ra.model.service.ProductService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/product")
public class ProductController {
@Autowired
    private ProductService productService;
    @Autowired
    private CatalogService catalogService;
@GetMapping
    public List<Product> GetAllProduct(){
    return productService.findAll();
    }
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable("productId")int id){
    return productService.findById(id);
    }
    @PostMapping("/{catalogId}")
    public Product createProduct(@RequestBody Product product,@PathVariable("catalogId") int id){
    Catalog catalog = catalogService.findById(id);
    product.setCatalog(catalog);
    return productService.saveOrUpdate(product);
    }
    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") int id,@RequestBody Product product){
    Product productUpdate = productService.findById(id);
    productUpdate.setProductName(product.getProductName());
    productUpdate.setPrice(product.getPrice());
    productUpdate.setDescription(product.getDescription());
    productUpdate.setCreateDate(product.getCreateDate());
    productUpdate.setStatus(productUpdate.isStatus());
    return productService.saveOrUpdate(productUpdate);
    }
    @DeleteMapping("/{productId}")
    public void deleteProduct (@PathVariable("productId") int id){
     productService.delete(id);
    }
    @GetMapping("/search")
    public List<Product> searchByNameOrId(@RequestParam("productName") String productName,@RequestParam("productId") int id){
    return productService.searchByName(productName,id);
    }
}

