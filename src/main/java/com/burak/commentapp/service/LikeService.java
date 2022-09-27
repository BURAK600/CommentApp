package com.burak.commentapp.service;

import com.burak.commentapp.repository.ILikeRepository;
import com.burak.commentapp.repository.entity.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final ILikeRepository iLikeRepository;

    public Like save(Like like){

        return iLikeRepository.save(like);
    }

}
