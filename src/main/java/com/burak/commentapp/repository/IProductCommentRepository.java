package com.burak.commentapp.repository;

import com.burak.commentapp.repository.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductCommentRepository extends JpaRepository<ProductComment, Long> {

    Optional<List<ProductComment>> findAllOptionalByProductId(Long productId);

    Optional<List<ProductComment>> findAllOptionalByProductIdAndCommentDateBetween(Long productId, LocalDate date1, LocalDate date);

    Optional<List<ProductComment>> findAllOptionalByUserId(Long userId);

    Optional<List<ProductComment>> findAllOptionalByUserIdAndCommentDateBetween(Long userId, LocalDate date1, LocalDate date2);

    Optional<List<ProductComment>> findAllOptionalByCommentContainingIgnoreCase(String comment);

    @Query("select pc from ProductComment pc where length(pc.comment) > ?1")
    List<ProductComment> findByCommentLength(int x);

    @Query("select pc from ProductComment pc where pc.comment like ('%çok güzel%')")
    Optional<List<ProductComment>> findByCommnetContainCokGuzel();













}
