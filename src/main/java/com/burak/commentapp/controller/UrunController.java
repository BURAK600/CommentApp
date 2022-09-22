package com.burak.commentapp.controller;

import com.burak.commentapp.repository.entity.Urun;
import com.burak.commentapp.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/urun")
@RequiredArgsConstructor
public class UrunController {

    private final UrunService urunService;

    @GetMapping("/save")
    public ResponseEntity<Urun> saveUrun(String ad, Double fiyat, LocalDate sonKullanmaTarihi){
        Urun urun;
        urun = Urun.builder().ad(ad).fiyat(fiyat).sonKullanmaTarihi(sonKullanmaTarihi)
                .build();
       return ResponseEntity.ok(urunService.save(urun));


    }

    @GetMapping("/findall")
    public ResponseEntity<List<Urun>> findAll(){
        return ResponseEntity.ok(urunService.findAll());
    }


    @GetMapping("/findAllByFiyatGreaterThan")
    public ResponseEntity<Optional<List<Urun>>> findAllByFiyatGreaterThan(Double fiyat){
        return ResponseEntity.ok(urunService.findAllByFiyatGreaterThan(fiyat));
    }

    @GetMapping("/findAllBySonKullanmaTarihiBefore")
    public ResponseEntity<Optional<List<Urun>>> findAllOptionalBySonKullanmaTarihiBefore(LocalDate date){
        return ResponseEntity.ok(urunService.findAllOptionalBySonKullanmaTarihiBefore(date));
    }

    @GetMapping("/findAllBySonKullanmaTarihiAfterOrSonKullanmaTarihiIsNull")
    public ResponseEntity<Optional<List<Urun>>> findAllOptionalBySonKullanmaTarihiAfterOrSonKullanmaTarihiIsNull(LocalDate date){
        return ResponseEntity.ok(urunService.findAllOptionalBySonKullanmaTarihiAfterOrSonKullanmaTarihiIsNull(date));
    }

    @GetMapping("/searchUrunByFiyat")
    public ResponseEntity<Optional<Object[]>> searchUrunByFiyat(Double price){
        return ResponseEntity.ok(urunService.searchUrunByFiyat(price));
    }

    @GetMapping("/countSonKullanmaTarihi")

    public ResponseEntity<Integer> countSonKullanmaTarihi(LocalDate date){
        return ResponseEntity.ok(urunService.countSonKullanmaTarihi(date));
    }

    @GetMapping("/findAllOptionalByFiyatIn")

    public ResponseEntity<Optional<List<Urun>>> findAllOptionalByFiyatIn(List<Double> fiyats){
        return ResponseEntity.ok(urunService.findAllOptionalByFiyatIn(fiyats));

    }

    @GetMapping("/findAllOptionalByAdIn")

    public ResponseEntity<Optional<List<Urun>>> findAllOptionalByAdIn(List<String> ads){
        return ResponseEntity.ok(urunService.findAllOptionalByAdIn(ads));
    }




    @GetMapping("/findAllBySonKullanmaTarihiAfter")
    public ResponseEntity<Optional<List<Urun>>> findSonKullanmaTarihiBitecekAltıAy(LocalDate date){
        return ResponseEntity.ok(urunService.findSonKullanmaTarihiBitecekAltıAy(date));
    }













}
