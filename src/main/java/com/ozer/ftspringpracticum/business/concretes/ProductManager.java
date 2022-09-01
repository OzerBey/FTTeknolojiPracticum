package com.ozer.ftspringpracticum.business.concretes;

import com.ozer.ftspringpracticum.business.abstracts.ProductService;
import com.ozer.ftspringpracticum.business.abstracts.SequenceGeneratorService;
import com.ozer.ftspringpracticum.core.utilities.results.*;
import com.ozer.ftspringpracticum.dataAccess.ProductDao;
import com.ozer.ftspringpracticum.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public ProductManager(ProductDao productDao, SequenceGeneratorService sequenceGeneratorService) {
        this.productDao = productDao;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public Result add(Product product) {
        product.setId((long) sequenceGeneratorService.getSequenceNumber(product.SEQUENCE_NAME));
        if (!product.equals(null)) {
            this.productDao.insert(product);
            return new SuccessResult("Product added successfully");
        }
        return new ErrorResult("Product don't add to db");
    }

    @Override
    public Result deleteById(Long id) {
        return null;
    }

    @Override
    public Result update(Product product) {
        return null;
    }

    @Override
    public DataResult<Optional<Product>> getById(Long productId) {
        return new SuccessDataResult<>(this.productDao.findById(productId), "Product listed");
    }

    @Override
    public DataResult<List<Product>> getByExpiredDate() {
        List<Product> list = new ArrayList<>();
        getAll().getData().forEach((product -> {
            boolean isExpired = java.time.LocalDate.now().isAfter(product.getExpirationDate());
            if (isExpired) {
                list.add(product);
                System.err.println(product.getExpirationDate());
            }
        }));
        return new SuccessDataResult<List<Product>>(list, "Prodcuts listed");
    }

    @Override
    public DataResult<List<Product>> getByNotExpiredDate() {
        List<Product> list = new ArrayList<>();
        getAll().getData().forEach((product) -> {
            list.add(product);
            boolean isExpired = java.time.LocalDate.now().isAfter(product.getExpirationDate());
            if (!isExpired) {
                list.add(product);
            }
        });
        return new SuccessDataResult<List<Product>>(list, "Products listed");
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(this.productDao.findAll(), "All of products listed");
    }
}
