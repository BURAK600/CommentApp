package com.burak.commentapp.controller;

import com.burak.commentapp.repository.entity.User;
import com.burak.commentapp.repository.entity.Like;
import com.burak.commentapp.repository.entity.Product;
import com.burak.commentapp.service.UserService;
import com.burak.commentapp.service.LikeService;
import com.burak.commentapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;
    private final UserService userService;
    private final ProductService productService;

    @GetMapping("/likeNumber")
    public ResponseEntity<Optional<Like>> toLike(Long userId, Long productId){
        Optional<User> userDb = userService.findById(userId);
        Optional<Product> productDb = productService.findById(productId);

        if(userDb.isPresent()&&productDb.isPresent()){

            Like like = likeService.save(Like.builder().likedDate(LocalDate.now()).userId(userId).productId(productId).build());
            productDb.get().getLikes().add(like.getId());
            productService.save(productDb.get());
            return ResponseEntity.ok(Optional.of(like));
        }
        return ResponseEntity.ok(Optional.ofNullable(null));




    }

}
