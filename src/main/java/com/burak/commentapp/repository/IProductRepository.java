package com.burak.commentapp.repository;

import com.burak.commentapp.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {



    Optional<List<Product>> findAllOptionalByPriceGreaterThan(Double price);

    Optional<List<Product>> findAllOptionalByExpirationDateBefore(LocalDate date);



    Optional<List<Product>> findAllOptionalByExpirationDateAfterOrExpirationDateIsNull(LocalDate date);


    @Query("select k.price, count(k.price) from Product k group by k.price")
    Optional<Object[]> searchProductByPrice(Double price);

    int countAllByExpirationDate(LocalDate date);


    Optional<List<Product>> findAllOptionalByPriceIn(List<Double> prices);

    Optional<List<Product>> findAllOptionalByNameIn(List<String> names);


    Optional<List<Product>> findAllOptionalByExpirationDateBetween(LocalDate now, LocalDate nextDate);
























}
