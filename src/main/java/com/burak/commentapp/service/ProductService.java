package com.burak.commentapp.service;


import com.burak.commentapp.dto.request.ProductCreateRequestDto;
import com.burak.commentapp.dto.response.ProductCreateResponseDto;
import com.burak.commentapp.dto.response.UserCreateResponseDto;
import com.burak.commentapp.mapper.ProductMapper;
import com.burak.commentapp.mapper.UserMapper;
import com.burak.commentapp.repository.IProductRepository;
import com.burak.commentapp.repository.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final IProductRepository productRepository;



    public Product save(Product product){
        return productRepository.save(product);
    }

    public ProductCreateResponseDto saveDto(Product product){
        productRepository.save(product);
        return ProductMapper.INSTANCE.toProductCreateResponseDto(product);
    }


    public List<Product> findAll(){
        return  productRepository.findAll();
    }


    public Optional<List<Product>> findAllOptionalByPriceGreaterThan(Double price){

        return productRepository.findAllOptionalByPriceGreaterThan(price);
    }


    public  Optional<List<Product>> findAllOptionalByExpirationDateBefore(LocalDate date){

        return  productRepository.findAllOptionalByExpirationDateBefore(date);
    }

    public  Optional< Object[]>  searchProductByPrice(Double price){

        return  productRepository.searchProductByPrice(price);
    }

    public Optional<List<Product>> findAllOptionalByExpirationDateAfterOrExpirationDateIsNull(LocalDate date){

        return  productRepository.findAllOptionalByExpirationDateAfterOrExpirationDateIsNull(date);
    }
    public  int countAllByExpirationDate(LocalDate date){
        return  productRepository.countAllByExpirationDate(date);
    }

    public Optional<List<Product>> findAllOptionalByPriceIn(List<Double> prices){
        return  productRepository.findAllOptionalByPriceIn(prices);
    }

    public Optional<List<Product>> findAllOptionalByNameIn(List<String> productNames){
        return  productRepository.findAllOptionalByNameIn(productNames);
    }


    public List<Product> findAllOptionalByExpirationDateBetween(){
        LocalDate  now=LocalDate.now();
        LocalDate nextDate=LocalDate.now().plusMonths(6);
//    List<Product> productList=productRepository.findAllOptionalByExpirationDateBetween(now,nextDate).get();
//    productList.forEach(x-> x.setPrice(x.getPrice()*0.9));

        return  productRepository.findAllOptionalByExpirationDateBetween(now,nextDate).get().stream().map(x->{
            x.setPrice(x.getPrice()*0.9);
            productRepository.save(x);
            return  x;
        } ).collect(Collectors.toList());

    }

    public Optional<Product> findById(Long productId) {
        Optional<Product> product= productRepository.findById(productId);
        if (product.isPresent()){

            return  product;
        }
        System.out.println("Urun bulunamadi");
        return Optional.ofNullable(null);

    }

    public List<Product> saveAll(List<Product> products) {

        return productRepository.saveAll(products);
    }

    public ProductCreateResponseDto saveWithRequestDto(ProductCreateRequestDto productCreateRequestDto) {
        Product product = ProductMapper.INSTANCE.toProduct(productCreateRequestDto);
        productRepository.save(product);
        return ProductMapper.INSTANCE.toProductCreateResponseDto(product);
    }
}

