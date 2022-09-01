package com.ozer.ftspringpracticum.business.abstracts;

import com.ozer.ftspringpracticum.core.utilities.exceptions.UserNotFoundException;
import com.ozer.ftspringpracticum.core.utilities.results.DataResult;
import com.ozer.ftspringpracticum.core.utilities.results.Result;
import com.ozer.ftspringpracticum.entities.concretes.Product;
import com.ozer.ftspringpracticum.entities.concretes.User;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    Result add(Product product);

    Result deleteById(Long id);

    Result update(Product product);

    DataResult<Optional<Product>> getById(Long productId);

    DataResult<List<Product>> getByExpiredDate();

    DataResult<List<Product>> getByNotExpiredDate();

    DataResult<List<Product>> getAll();
}
