package com.burak.commentapp.repository;

import com.burak.commentapp.repository.entity.Like;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILikeRepository extends JpaRepository<Like, Long> {






}
