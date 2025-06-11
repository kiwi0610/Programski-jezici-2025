package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Korisnik;
import rs.ac.singidunum.repository.KorisnikRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/korisnik")
@CrossOrigin
@RequiredArgsConstructor
public class KorisnikController {

    private final KorisnikRepository repository;

    @GetMapping
    public List<Korisnik> getKorisnik(){
        return repository.findAllByDeletedAtIsNull();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Korisnik> getCustomerById(@PathVariable Integer id){
        return ResponseEntity.of(repository.findById(id));
    }



    @PostMapping
    public Korisnik saveCustomer(@RequestBody Korisnik model){
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(model.getIme());
        korisnik.setPrezime(model.getPrezime());
        korisnik.setPaketId(model.getPaketId());
        korisnik.setEmail(model.getEmail());
        korisnik.setTelefon(model.getTelefon());
        korisnik.setNapomena(model.getNapomena());
        korisnik.setCreatedAt(LocalDateTime.now());
        return repository.save(korisnik);
    }

    @PutMapping
    public Korisnik updateCustomer(@PathVariable Integer id,@RequestBody Korisnik model){

        Korisnik korisnik = repository.findById(id).orElseThrow();

        korisnik.setIme(model.getIme());
        korisnik.setPrezime(model.getPrezime());
        korisnik.setPaketId(model.getPaketId());
        korisnik.setEmail(model.getEmail());
        korisnik.setTelefon(model.getTelefon());
        korisnik.setNapomena(model.getNapomena());
        korisnik.setUpdatedAt(LocalDateTime.now());
        return repository.save(korisnik);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Integer id){

        Korisnik korisnik = repository.findById(id).orElseThrow();
        korisnik.setDeletedAt(LocalDateTime.now());
        repository.save(korisnik);
    }

}
