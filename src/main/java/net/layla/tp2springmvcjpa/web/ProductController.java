package net.layla.tp2springmvcjpa.web;

import net.layla.tp2springmvcjpa.entities.Product;
import net.layla.tp2springmvcjpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index" ;
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("productList", products);
        return "products" ;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/newProduct")
    public String newProduct (Model model) {
        model.addAttribute("product", new Product());
        return "new-product" ;
    }
}
