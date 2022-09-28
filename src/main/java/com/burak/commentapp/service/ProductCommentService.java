package com.burak.commentapp.service;



import com.burak.commentapp.dto.request.ProductCommentCreateRequestDto;
import com.burak.commentapp.dto.response.ProductCommentCreateResponseDto;
import com.burak.commentapp.mapper.ProductCommentMapper;
import com.burak.commentapp.repository.IProductCommentRepository;
import com.burak.commentapp.repository.entity.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCommentService {

    private final IProductCommentRepository iProductCommentRepository;

    public ProductComment save(ProductComment productComment){
        return iProductCommentRepository.save(productComment);
    }


    public ProductComment update(ProductComment productComment){
        return iProductCommentRepository.save(productComment);
    }

    public void delete(ProductComment productComment){
        iProductCommentRepository.delete(productComment);
    }

    public List<ProductComment> findAll(){
        return iProductCommentRepository.findAll();

    }


    public Optional<List<ProductComment>> findAllOptionalByUrunId(Long productId){
        return findAllOptionalByUrunId(productId);
    }

    public Optional<List<ProductComment>> findAllOptionalByProductIdAndCommentDateBetween(Long productId, LocalDate date1, LocalDate date){
        return findAllOptionalByProductIdAndCommentDateBetween(productId, date1, date);
    }

   public Optional<List<ProductComment>> findAllOptionalByUserId(Long userId){
        return findAllOptionalByUserId(userId);

   }

   public Optional<List<ProductComment>> findAllOptionalByUserIdAndCommentDateBetween(Long userId, LocalDate date1, LocalDate date2){
        return findAllOptionalByUserIdAndCommentDateBetween(userId,date1,date2);
   }

    public Optional<List<ProductComment>> findAllOptionalByCommentContainingIgnoreCase(String yorum){
        return findAllOptionalByCommentContainingIgnoreCase(yorum);
    }


    public List<ProductComment> getProductCommentLenght(int x){

        return getProductCommentLenght(x);
    }


    public Optional<List<ProductComment>> findAllOptionalByCommentIn(List<String> comments){
        return findAllOptionalByCommentIn(comments);
    }

    public List<ProductComment> findByList(){
        List<String> list = new ArrayList<>();
        list.add("çok güzel");
        list.add("iyi");

        List<ProductComment> productComments = iProductCommentRepository.findAll().stream().filter(x->{

            for (int i = 0;i<list.size();i++){
                if(x.getComment().contains(list.get(i))){
                    return true;

                }
            }
            return false;
        }).collect(Collectors.toList());

        return productComments;
    }

    public List<ProductComment> findByList(String[] array){

        List<ProductComment> productComments = iProductCommentRepository.findAll().stream().filter(x->{

            for (int i = 0;i<array.length;i++){
                if(x.getComment().contains(array[i])){
                    return true;

                }
            }
            return false;
        }).collect(Collectors.toList());

        return productComments;
    }


    public void saveAll(List<ProductComment> productComment) {
        iProductCommentRepository.saveAll(productComment);
    }

    public ProductCommentCreateResponseDto saveWithRequestDto(ProductCommentCreateRequestDto productCommentCreateRequestDto) {
  ProductComment productComment = ProductCommentMapper.INSTANCE.toProductComment(productCommentCreateRequestDto);
  iProductCommentRepository.save(productComment);
  return ProductCommentMapper.INSTANCE.toProductCommentCreateResponseDto(productCommentCreateRequestDto);
    }
}
