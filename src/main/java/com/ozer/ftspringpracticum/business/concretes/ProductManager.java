package com.ozer.ftspringpracticum.business.concretes;

import com.ozer.ftspringpracticum.business.abstracts.ProductService;
import com.ozer.ftspringpracticum.business.abstracts.SequenceGeneratorService;
import com.ozer.ftspringpracticum.core.utilities.results.*;
import com.ozer.ftspringpracticum.dataAccess.ProductDao;
import com.ozer.ftspringpracticum.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductManager implements ProductService {

    private final ProductDao productDao;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public ProductManager(ProductDao productDao, SequenceGeneratorService sequenceGeneratorService) {
        this.productDao = productDao;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public Result add(Product product) {
        product.setId((long) sequenceGeneratorService.getSequenceNumber(Product.SEQUENCE_NAME));
        this.productDao.insert(product);
        return new SuccessResult("Product added successfully");
    }

    @Override
    public Result deleteById(Long id) {
        if (getById(id) != null) {
            this.productDao.deleteById(id);
            return new SuccessResult("Product deleted successfully");
        }
        return new ErrorResult("Product deleting failed");
    }

    @Override
    public Result update(Product product) {
        Optional<Product> getProduct = productDao.findById(product.getId());
        if (getProduct.isEmpty()) {
            return new ErrorResult("Product id not found !!");
        }
        this.productDao.save(product);

        return new SuccessResult("Product updated");
    }

    @Override
    public DataResult<Optional<Product>> getById(Long productId) {
        Optional<Product> getProduct = productDao.findById(productId);
        if (getProduct.isEmpty()) return new ErrorDataResult<>("Product id not found !!");
        return new SuccessDataResult<>(this.productDao.findById(productId), "Product by their id listed");
    }

    @Override
    public DataResult<List<Product>> getByExpiredDate() {
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < getAll().getData().size(); i++) {
            Product tempProduct = getAll().getData().get(i);
            if (tempProduct.getExpirationDate() != null) {
                boolean isExpired = java.time.LocalDate.now().isAfter(tempProduct.getExpirationDate());
                if (isExpired) {
                    list.add(tempProduct);
                }
            }
        }
        return new SuccessDataResult<>(list, "Expired products are listed.");
    }

    @Override
    public DataResult<List<Product>> getByNotExpiredDate() {
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < getAll().getData().size(); i++) {
            Product tempProduct = getAll().getData().get(i);
            if (tempProduct.getExpirationDate() == null) {
                list.add(tempProduct);
            } else {
                boolean isExpired = java.time.LocalDate.now().isAfter(tempProduct.getExpirationDate());
                if (!isExpired) {
                    list.add(tempProduct);
                }
            }
        }
        return new SuccessDataResult<>(list, "Products that have not expired are listed.");
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(this.productDao.findAll(), "All of products listed");
    }
}
