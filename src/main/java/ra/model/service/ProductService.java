package ra.model.service;

import ra.model.entity.Product;

import java.util.List;

public interface ProductService{
    List<Product> findAll();
    Product findById(int id);
    Product saveOrUpdate(Product product);
    void delete(int id);
    List<Product> searchByName(String productName,int id);
    List<Product> CatalogOneToManyProduct(int id);
}
