package com.burak.commentapp.repository;

import com.burak.commentapp.repository.entity.Urun;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface IUrunRepository extends JpaRepository<Urun, Long> {



    Optional<List<Urun>> findAllByFiyatGreaterThan(Double fiyat);

    Optional<List<Urun>> findAllOptionalBySonKullanmaTarihiBefore(LocalDate date);



    Optional<List<Urun>> findAllOptionalBySonKullanmaTarihiAfterOrSonKullanmaTarihiIsNull(LocalDate date);


    @Query("select k.fiyat, count(k.fiyat) from Kullanıcı k group by k.fiyat")

    Optional<Object[]> searchUrunByFiyat(Double price);

    int countSonKullanmaTarihi(LocalDate date);


    Optional<List<Urun>> findAllOptionalByFiyatIn(List<Double> fiyats);

    Optional<List<Urun>> findAllOptionalByAdIn(List<String> ads);

    List<Urun> findSonKullanmaTarihiBitecekAltıAy(LocalDate date);
























}
