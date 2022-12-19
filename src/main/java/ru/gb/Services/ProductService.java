package ru.gb.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.data.ProductDao;
import ru.gb.models.Product;
import java.util.List;

@Service
public class ProductService {           // слой между контроллером и БД

    private ProductDao productDao;
    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product findById(Long id) {
        return productDao.findById(id);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public Product saveOrUpdate(Product product) {
        return productDao.saveOrUpdate(product);
    }

        // старый вариант с репозиторием

    /*private ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void add(ProductOld product) {
        productRepository.addProduct(product);
    }

    public List<ProductOld> getAllProducts() {return  productRepository.getProducts(); }

    public String findOneProduct(Long id) {return productRepository.findById(id).toString();}

    public void deleteById(Long id) { productRepository.deleteById(id);}*/
}
