package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.entity.Korisnik;
import rs.ac.singidunum.repository.KorisnikRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/api/korisnik")
@CrossOrigin
@RequiredArgsConstructor
public class KorisnikController {

    private final KorisnikRepository repository;

    @GetMapping
    public List<Korisnik> getKorisniks(){
        return repository.findAll();
    }


}
