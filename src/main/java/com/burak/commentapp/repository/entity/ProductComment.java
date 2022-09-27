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
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String comment;

    private LocalDate commentDate;

    private Long productId;

    private Long userId;


}


