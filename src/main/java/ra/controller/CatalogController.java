package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ra.DTO.CatalogDTO;
import ra.model.entity.Catalog;
import ra.model.service.CatalogService;
import ra.model.service.ProductService;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Catalog> GetAllCatalog(){
        return catalogService.findAll();
    }
    @GetMapping("/{catalogId}")
   public CatalogDTO OneToManyProduct(@PathVariable("catalogId") int id){
        CatalogDTO catalogDTO = new CatalogDTO();
        Catalog catalog = catalogService.findById(id);
        catalogDTO.setCatalogId(catalog.getCatalogId());
        catalogDTO.setCatalogName(catalog.getCatalogName());
        catalogDTO.setCreateDate(catalog.getCreateDate());
        catalogDTO.setStatus(catalog.isStatus());
        catalogDTO.setListProducts(productService.CatalogOneToManyProduct(id));
        return catalogDTO;
    }
    @PostMapping
    public Catalog createCatalog(@RequestBody Catalog catalog){
        return catalogService.saveOrUpdate(catalog);
    }
    @PutMapping("/{catalogId}")
    public Catalog updateCatalog(@PathVariable("catalogId") int id,@RequestBody Catalog catalog){
        Catalog catalogUpdate = catalogService.findById(id);
        catalogUpdate.setCatalogName(catalog.getCatalogName());
        catalogUpdate.setCreateDate(catalog.getCreateDate());
        catalogUpdate.setStatus(catalog.isStatus());
        return catalogService.saveOrUpdate(catalogUpdate);
    }
    @DeleteMapping("/{catalogId}")
    public void deleteCatalog(@PathVariable("catalogId") int id){
        catalogService.delete(id);
    }
    @GetMapping("/search")
    public List<Catalog> searchByNameOrId(@RequestParam("catalogName") String catalogName,@RequestParam("catalogId") int catalogId){
        return catalogService.searchByNameOrId(catalogName,catalogId);
    }
}
