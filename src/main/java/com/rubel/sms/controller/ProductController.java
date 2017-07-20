package com.rubel.sms.controller;

import com.rubel.sms.model.Product;
import com.rubel.sms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by rubel on 7/18/17.
 */

@Controller
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping
    public String product(@RequestParam(name = "id", required = false) Long id, Model model){
        if(id == null){
            List<Product> products = productService.findAll();
            model.addAttribute("products", products);
            return "products";
        }

        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createProduct(@ModelAttribute("product") Product product, BindingResult result){
        if(result.hasErrors()){
            return new ModelAndView("redirect:/products/create");
        }

        productService.saveOrUpdate(product);

        return new ModelAndView("redirect:/products");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView formProduct(@ModelAttribute("product") Product product){
        return new ModelAndView("productForm");
    }

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public ModelAndView findProductsByCategory(@ModelAttribute("product") Product product, @PathVariable("category")
            String category){
        List<Product> products = productService.findAllByCatergory(category);
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @RequestMapping(value = "/filter/{params}", method = RequestMethod.GET)
    public ModelAndView findProductsByCategory(@ModelAttribute("product") Product product, @MatrixVariable(pathVar = "params")
                                               Map<String, List<String>> filterParams){
        List<Product> products = productService.getProductsByFilter(filterParams);
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}