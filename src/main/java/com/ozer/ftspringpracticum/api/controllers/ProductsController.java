package com.ozer.ftspringpracticum.api.controllers;

import com.ozer.ftspringpracticum.business.abstracts.ProductService;
import com.ozer.ftspringpracticum.core.utilities.results.DataResult;
import com.ozer.ftspringpracticum.core.utilities.results.Result;
import com.ozer.ftspringpracticum.entities.concretes.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/products")
public class ProductsController {

    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("getById")
    public DataResult<Optional<Product>> getById(Long id) {
        return this.productService.getById(id);
    }

    @GetMapping("getByExpiredDate")
    public DataResult<List<Product>> getByExpiredDate() {
        return this.productService.getByExpiredDate();
    }

    @GetMapping("getByNotExpiredDate")
    public DataResult<List<Product>> getByNotExpiredDate() {
        return this.productService.getByNotExpiredDate();
    }

    @GetMapping("getAll")
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

}
