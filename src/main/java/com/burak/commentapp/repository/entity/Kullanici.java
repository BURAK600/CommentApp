package com.burak.commentapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Table(name = "tblkullanici")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Kullanici {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
@Column(length = 50)
private String ad;
@Column(length = 50)
private String soyad;
@Column(length = 50)
private String email;
@Column(length = 15)
private String telefon;
@Column(length = 32)
private String password;




}
