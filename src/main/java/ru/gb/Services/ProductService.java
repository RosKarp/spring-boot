package ru.gb.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.data.ProductRepository;
import ru.gb.models.Product;
import java.util.List;

@Service
public class ProductService {           // слой между контроллером и репозиторием

    private ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void add(Product product) {
        productRepository.addProduct(product);
    }

    public List<Product> getAllProducts() {return  productRepository.getProducts(); }

    public String findOneProduct(Long id) {return productRepository.findById(id).toString();}

    public void deleteById(Long id) { productRepository.deleteById(id);}
}
