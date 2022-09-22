package com.burak.commentapp.service;

import com.burak.commentapp.repository.IKullaniciRepository;
import com.burak.commentapp.repository.entity.Kullanici;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KullaniciService {

    private final IKullaniciRepository iKullaniciRepository;

    public Kullanici save(Kullanici kullanici){
        return iKullaniciRepository.save(kullanici);
    }

    public Kullanici update(Kullanici kullanici){
        return iKullaniciRepository.save(kullanici);
    }

    public void delete(Kullanici kullanici){
        iKullaniciRepository.delete(kullanici);
    }

    public List<Kullanici> findAll(){
        return iKullaniciRepository.findAll();

    }


    public List<Kullanici> findAllByOrderByAd(){
        return iKullaniciRepository.findAllByOrderByAd();
    }

    public Optional<List<Kullanici>> findAllOptionalByAdContainingIgnoreCase(String ad){
        return iKullaniciRepository.findAllOptionalByAdContainingIgnoreCase(ad);
    }

    public  Optional<List<Kullanici>> findAllOptionalByEmailContainingIgnoreCase(String email){
        return iKullaniciRepository.findAllOptionalByEmailContainingIgnoreCase(email);

    }

    public Optional<List<Kullanici>> findAllOptionalByEmailEndingWith(String email){
        return iKullaniciRepository.findAllOptionalByEmailEndingWith(email);
    }

    public  Optional<Kullanici> findOptionalByEmailAndPassword(String email, String password){
        return iKullaniciRepository.findOptionalByEmailAndPassword(email,password);
    }

    public Optional<Kullanici> passwordUzunluguGreaterThan(int x){
        return iKullaniciRepository.passwordUzunluguGreaterThan(x);
    }


}
