package com.burak.commentapp.controller;

import com.burak.commentapp.repository.entity.Urun;
import com.burak.commentapp.repository.entity.UrunYorum;
import com.burak.commentapp.service.UrunService;
import com.burak.commentapp.service.UrunYorumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/urunyorum")
@RequiredArgsConstructor
public class UrunYorumController {

    private final UrunYorumService urunYorumService;

    @GetMapping("/save")

    public ResponseEntity<UrunYorum> saveUrunYorum(String yorum, LocalDate yorumTarihi){
        UrunYorum urunYorum;
        urunYorum = UrunYorum.builder().yorum(yorum).yorumTarihi(yorumTarihi)
                .build();
       return ResponseEntity.ok(urunYorumService.save(urunYorum));

    }

    @GetMapping("/findall")
    public ResponseEntity<List<UrunYorum>> findAll(){
        return ResponseEntity.ok(urunYorumService.findAll());
    }
}
