package com.burak.commentapp.service;

import com.burak.commentapp.dto.response.UserCreateResponseDto;
import com.burak.commentapp.dto.response.UserFindAllResponseDto;
import com.burak.commentapp.mapper.UserMapper;
import com.burak.commentapp.repository.IUserRepository;
import com.burak.commentapp.repository.entity.User;
import com.burak.commentapp.repository.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private   IUserRepository userRepository;
    @Autowired
    private  ProductService productService;

    public  User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return  userRepository.findAll();
    }


    public List<User> findAllUserByOrderByName(){

        return userRepository.findAllByOrderByName();

    }

    public Optional<List<User>> containsName(String value){

        return userRepository.findAllOptionalByNameContainingIgnoreCase(value);
    }

    public Optional<List<User>> containsEmaiil(String value){

        return userRepository.findAllOptionalByEmailContainingIgnoreCase(value);
    }

    public Optional<List<User>> endWithEmaiil(String value){

        return userRepository.findAllOptionalByEmailEndingWith(value);
    }

    public Optional<User> login (String email,String password){

        return userRepository.findOptionalByEmailAndPassword(email,password);
    }
    public Optional<User> loginNativeQuery (String email,String password){

        return userRepository.findOptionalByEmailAndPassword2(email,password);
    }

    public Optional<List<User>> controlPasswordLength(int value){

        return userRepository.controlPasswordLength(value);
    }

    public Optional<List<User>> controlPasswordlength2(int value){

        return userRepository.controlPasswordlength2(value);
    }

    public Optional<User> addFav(Long userId, Long productId) {
        Optional<User> user= userRepository.findById(userId);
        Optional<Product> product= productService.findById(productId);

        if (user.isPresent()&&product.isPresent()){
            user.get().getFavProducts().add(productId);
            return Optional.of(userRepository.save(user.get()));
        }
        System.out.println("Urun eklenemedi");
        return  Optional.ofNullable(null);

    }

    public List<User> saveAll(List<User> users) {

        return userRepository.saveAll(users);
    }

    public Optional<User> findById(Long userId) {

        return  userRepository.findById(userId);
    }

    public UserCreateResponseDto saveDto(User user) {

        userRepository.save(user);
        return  UserCreateResponseDto.builder().name(user.getName()).surName(user.getSurName())
                .telephone(user.getTelephone()).surName(user.getSurName()).build();


    }

    public UserCreateResponseDto saveDto2(User user) {
        userRepository.save(user);
        return UserMapper.INSTANCE.toUserCreateResponseDto(user);
    }
    public UserFindAllResponseDto findAllResponseDto(User user){
        userRepository.findAll();
        return UserMapper.INSTANCE.toUserFindAllResponseDto(user);
    }
}
