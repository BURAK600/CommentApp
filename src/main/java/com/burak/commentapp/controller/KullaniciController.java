package com.burak.commentapp.controller;

import com.burak.commentapp.repository.entity.Kullanici;
import com.burak.commentapp.service.KullaniciService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kullanici")
@RequiredArgsConstructor
public class KullaniciKontroller {

    private final KullaniciService kullaniciService;

    @GetMapping("/save")
    public ResponseEntity<Kullanici> saveKullanici(String ad, String soyad, String email, String telefon, String password){
        Kullanici kullanici = Kullanici.builder().ad(ad).soyad(soyad).email(email).telefon(telefon).password(password)
                .build();
       return ResponseEntity.ok(kullaniciService.save(kullanici));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Kullanici>> findAll(){
        return ResponseEntity.ok(kullaniciService.findAll());
    }


    @GetMapping("/findAllByAdOrdeyByDesc")
    public ResponseEntity<List<Kullanici>> findAllByOrderByAd(){
        return ResponseEntity.ok(kullaniciService.findAllByOrderByAd());
    }


    @GetMapping("/findAllOptionalByAdContainingIgnoreCase")
    public ResponseEntity<Optional<List<Kullanici>>> findAllOptionalByAdContainingIgnoreCase(String ad){
        return ResponseEntity.ok(kullaniciService.findAllOptionalByAdContainingIgnoreCase(ad));
    }


@GetMapping("/findAllOptionalByEmailContainingIgnoreCase")
    public ResponseEntity<Optional<List<Kullanici>>> findAllOptionalByEmailContainingIgnoreCase(String email){
        return ResponseEntity.ok(kullaniciService.findAllOptionalByEmailContainingIgnoreCase(email));
    }


@GetMapping("/findAllOptionalByEmailEndingWith")
    public ResponseEntity<Optional<List<Kullanici>>> findAllOptionalByEmailEndingWith(String email){
        return ResponseEntity.ok(kullaniciService.findAllOptionalByEmailEndingWith(email));
    }


@GetMapping("/findOptionalByEmailAndPassword")
    public ResponseEntity<Optional<Kullanici>> findOptionalByEmailAndPassword(String email, String password){
        return ResponseEntity.ok(kullaniciService.findOptionalByEmailAndPassword(email,password));
    }


@GetMapping("/passwordUzunluguGreaterThan")
    public ResponseEntity<Optional<Kullanici>> passwordUzunluguGreaterThan(int x){
        return ResponseEntity.ok(kullaniciService.passwordUzunluguGreaterThan(x));
    }


}
