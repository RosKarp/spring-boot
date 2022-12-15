package ru.gb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.Services.ProductService;
import ru.gb.models.Product;
import java.util.List;

@Controller                           // обмен с фронтендом через html и JSON
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")                         // весь список через html
    public String allProducts(Model model) {
        model.addAttribute("allProducts", productService.getAllProducts());
        return "Products_page";
    }
    @GetMapping("/allJSON")         // весь список через JSON
    @ResponseBody
    public List<Product> allProductsJSON() {
        return productService.getAllProducts();
    }

    @GetMapping("/addProduct")                  // вывод формы для добавления
    public String showFormPage() {
        return "addProductForm";
    }

    @GetMapping("/addOneProduct")       // добавление продукта в репозиторий
    public String addProduct(@RequestParam Long id, @RequestParam String title, @RequestParam Float cost) {
        Product product = new Product(id,title, cost);
        productService.add(product);
        return "redirect:/products/all";
    }
    @GetMapping("/id/{id}")             // получение продукта по id
    @ResponseBody
    public String getProductById(@PathVariable Long id) {
    return productService.findOneProduct(id);
    }

    @GetMapping("/delete/{id}")         // удаление продукта из репозитория
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
