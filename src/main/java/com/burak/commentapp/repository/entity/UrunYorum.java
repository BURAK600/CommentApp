package com.burak.commentapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "tblurunyorum")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UrunYorum {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 500)
    private String yorum;

    private LocalDate yorumTarihi;

    private Long urunId;

    private Long kullaniciId;


}


