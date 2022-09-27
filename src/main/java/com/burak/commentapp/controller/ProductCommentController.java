package com.burak.commentapp.controller;

import com.burak.commentapp.repository.entity.ProductComment;
import com.burak.commentapp.service.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/urunyorum")
@RequiredArgsConstructor
public class ProductCommentController {

    private final ProductCommentService productCommentService;

    @GetMapping("/save")

    public ResponseEntity<ProductComment> saveProductComment(String comment, LocalDate commentDate){
        ProductComment productComment;
        productComment = ProductComment.builder().comment(comment).commentDate(commentDate)
                .build();
       return ResponseEntity.ok(productCommentService.save(productComment));

    }

    @GetMapping("/findall")
    public ResponseEntity<List<ProductComment>> findAll(){
        return ResponseEntity.ok(productCommentService.findAll());
    }

    @GetMapping("/indAllOptionalByProductId")
    public ResponseEntity<Optional<List<ProductComment>>> findAllOptionalByProductId(Long productId){

        return ResponseEntity.ok(productCommentService.findAllOptionalByUrunId(productId));
    }

    @GetMapping("/findAllOptionalByProductIdAndCommentDateBetween")
    public ResponseEntity<Optional<List<ProductComment>>> findAllOptionalByProductIdAndCommentDateBetween(long productId, LocalDate date1, LocalDate date){
        return ResponseEntity.ok(productCommentService.findAllOptionalByProductIdAndCommentDateBetween(productId,date1, date));
    }

    @GetMapping("/findAllOptionalByUserId")
    public ResponseEntity<Optional<List<ProductComment>>> findAllOptionalByUserId(Long userId){
        return ResponseEntity.ok(productCommentService.findAllOptionalByUserId(userId));

    }

    @GetMapping("/findAllOptionalByUserIdAndCommentDateBetween")
    public ResponseEntity<Optional<List<ProductComment>>> findAllOptionalByUserIdAndCommentDateBetween(Long userId, LocalDate date1, LocalDate date2){
        return ResponseEntity.ok(productCommentService.findAllOptionalByUserIdAndCommentDateBetween(userId,date1,date2));
    }
    @GetMapping("/findAllOptionalByCommentContainingIgnoreCase")
    public ResponseEntity<Optional<List<ProductComment>>> findAllOptionalByCommentContainingIgnoreCase(String comment){
        return ResponseEntity.ok(productCommentService.findAllOptionalByCommentContainingIgnoreCase(comment));
    }


    @GetMapping("/getProductCommentLenght")
    public ResponseEntity<List<ProductComment>> getProductCommentLenght(int x){
        return ResponseEntity.ok(productCommentService.getProductCommentLenght(x));
    }

@GetMapping("/findAllOptionalByCommentIn")
public ResponseEntity<Optional<List<ProductComment>>> findAllOptionalByCommentIn(List<String> comments){

    return ResponseEntity.ok(productCommentService.findAllOptionalByCommentIn(comments));
}

@GetMapping("/findByList")
public ResponseEntity<List<ProductComment>> findByList(){
        return ResponseEntity.ok(productCommentService.findByList());
}

@GetMapping("/findByList2")
public ResponseEntity<List<ProductComment>> findByList(String[] array){
        return ResponseEntity.ok(productCommentService.findByList(array));
}


}
