package com.burak.commentapp.service;



import com.burak.commentapp.repository.IUrunYorumRepository;
import com.burak.commentapp.repository.entity.Urun;
import com.burak.commentapp.repository.entity.UrunYorum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UrunYorumService {

    private final IUrunYorumRepository iUrunYorumRepository;

    public UrunYorum save(UrunYorum urunYorum){
        return iUrunYorumRepository.save(urunYorum);
    }

    public UrunYorum update(UrunYorum urunYorum){
        return iUrunYorumRepository.save(urunYorum);
    }

    public void delete(UrunYorum urunYorum){
        iUrunYorumRepository.delete(urunYorum);
    }

    public List<UrunYorum> findAll(){
        return iUrunYorumRepository.findAll();

    }

}
