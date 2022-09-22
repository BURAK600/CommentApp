package com.burak.commentapp.repository;

import com.burak.commentapp.repository.entity.UrunYorum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUrunYorumRepository extends JpaRepository<UrunYorum, Long> {

}
