package com.burak.commentapp.repository;

import com.burak.commentapp.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {


    List<User> findAllByOrderByName();

    Optional<List<User>> findAllOptionalByNameContainingIgnoreCase(String name);

    Optional<List<User>> findAllOptionalByEmailContainingIgnoreCase(String email);

    Optional<List<User>> findAllOptionalByEmailEndingWith(String email);

    Optional<User> findOptionalByEmailAndPassword(String email, String password);

    @Query(value = "select * from tbl_user as u where u.email=?1 and u.password=?2",nativeQuery = true)
    Optional<User> findOptionalByEmailAndPassword2(String email,String password);
    @Query("select u from User  u where length( u.password)> ?1")
    Optional<List<User>> controlPasswordLength(int value);

    @Query("select u from User  u where length( u.password)> :value")
    Optional<List<User>> controlPasswordlength2(@Param("value") int value);


    @Query("select count(u)>0 from User u where (u.email) = ?1 and u.password=?2")
    Boolean isExistUser(String txteEmail, String txtPassword);
}
