package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.model.entity.Catalog;
import ra.model.repository.CatalogRepository;
import ra.model.service.CatalogService;

import java.sql.SQLException;
import java.util.List;
@Service
@Transactional(rollbackFor = SQLException.class)
public class CatalogServiceImp implements CatalogService {
@Autowired
private CatalogRepository catalogRepository;
    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog findById(int id) {
        return catalogRepository.findById(id).get();
    }

    @Override
    public Catalog saveOrUpdate(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public void delete(int id) {
        catalogRepository.deleteById(id);
    }

    @Override
    public List<Catalog> searchByNameOrId(String catalogName, int catalogId) {
        return catalogRepository.findByCatalogNameOrCatalogId(catalogName, catalogId);
    }
}
