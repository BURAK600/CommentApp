package com.burak.commentapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Table(name = "tblurun")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String ad;
    private Double fiyat;
    private LocalDate sonKullanmaTarihi;



}
