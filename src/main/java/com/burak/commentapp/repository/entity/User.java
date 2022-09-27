package com.burak.commentapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "tbluser")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(length = 50)
private String name;
@Column(length = 50)
private String surName;
@Column(length = 50)
private String email;
@Column(length = 15)
private String telephone;
@Column(length = 32)
private String password;

    /**
     * Eger database de görmek istemiyorsak
     * @Transient  anatasyonu kullanılır.
     */

@ElementCollection
private List<Long> favProducts;







}
