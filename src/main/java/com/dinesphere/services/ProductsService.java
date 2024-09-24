package com.dinesphere.services;

import com.dinesphere.dtos.ProductsDTO;
import com.dinesphere.entities.Products;
import com.dinesphere.mappers.ProductsMapper;
import com.dinesphere.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productRepository;

    public ProductsDTO createProduct(ProductsDTO productDTO) {
        Products product = ProductsMapper.toEntity(productDTO);
        Products savedProduct = productRepository.save(product);
        return ProductsMapper.toDTO(savedProduct);
    }

    public Optional<ProductsDTO> getProduct(Long id) {
        return productRepository.findById(id).map(ProductsMapper::toDTO);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
