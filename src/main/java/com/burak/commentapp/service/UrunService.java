package com.burak.commentapp.service;


import com.burak.commentapp.repository.IUrunRepository;
import com.burak.commentapp.repository.entity.Urun;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrunService {


    private final IUrunRepository iUrunRepository;

    public Urun save(Urun urun) {
        return iUrunRepository.save(urun);
    }

    public Urun update(Urun urun) {
        return iUrunRepository.save(urun);
    }

    public void delete(Urun urun) {
        iUrunRepository.delete(urun);
    }

    public List<Urun> findAll() {
        return iUrunRepository.findAll();

    }



    public Optional<List<Urun>> findAllByFiyatGreaterThan(Double fiyat) {
        return iUrunRepository.findAllByFiyatGreaterThan(fiyat);
    }


    public Optional<List<Urun>> findAllOptionalBySonKullanmaTarihiBefore(LocalDate date) {
        return iUrunRepository.findAllOptionalBySonKullanmaTarihiBefore(date);
    }


    public Optional<List<Urun>> findAllOptionalBySonKullanmaTarihiAfterOrSonKullanmaTarihiIsNull(LocalDate date) {
        return iUrunRepository.findAllOptionalBySonKullanmaTarihiAfterOrSonKullanmaTarihiIsNull(date);
    }

    public Optional<Object[]> searchUrunByFiyat(Double price) {
        return iUrunRepository.searchUrunByFiyat(price);
    }

    public int countSonKullanmaTarihi(LocalDate date) {
        return iUrunRepository.countSonKullanmaTarihi(date);
    }

    public Optional<List<Urun>> findAllOptionalByFiyatIn(List<Double> fiyats) {
        return iUrunRepository.findAllOptionalByFiyatIn(fiyats);
    }

    public Optional<List<Urun>> findAllOptionalByAdIn(List<String> ads) {
        return iUrunRepository.findAllOptionalByAdIn(ads);

    }



    public Optional<List<Urun>> findSonKullanmaTarihiBitecekAltıAy(LocalDate date) {

        Optional<List<Urun>> uruns = iUrunRepository.findAllOptionalBySonKullanmaTarihiBefore(date.plusMonths(6));

uruns.stream().map(x->x.stream().map(y->{
    y.setFiyat(y.getFiyat()*0.9);
    return y;
}));
        return uruns;
    }


}

