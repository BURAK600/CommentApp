package com.burak.commentapp.repository;

import com.burak.commentapp.repository.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IKullaniciRepository extends JpaRepository<Kullanici, Long> {


    List<Kullanici> findAllByOrderByAd();

    Optional<List<Kullanici>> findAllOptionalByAdContainingIgnoreCase(String ad);

    Optional<List<Kullanici>> findAllOptionalByEmailContainingIgnoreCase(String email);

    Optional<List<Kullanici>> findAllOptionalByEmailEndingWith(String email);

    Optional<Kullanici> findOptionalByEmailAndPassword(String email, String password);

    @Query("select k from Kullanici k where length(k.password) > ?1")
    Optional<Kullanici> passwordUzunluguGreaterThan(int x);



    @Query("select k from Kullanici k where length(k.password) > ?1")
    Optional<Kullanici> passwordUzunluguGreaterThan2(int x);


    @Query(value = "select * from tblkullanici as u where u.email := email> ?1", nativeQuery = true)
    Optional<Kullanici> passwordUzunluguGreaterThan3(String email, String password);










}
