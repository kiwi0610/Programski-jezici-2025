package rs.ac.singidunum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Poruka;
import rs.ac.singidunum.repository.PorukaRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/poruke")
public class PorukaController {

    @Autowired
    private PorukaRepository porukaRepository;

    @GetMapping
    public List<Poruka> getSvePoruke() {
        return porukaRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> obrisiPoruku(@PathVariable Integer id) {
        if (!porukaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        porukaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePoruka(@PathVariable Integer id, @RequestBody Poruka novaPoruka) {
        return porukaRepository.findById(id)
                .map(poruka -> {
                    poruka.setIme(novaPoruka.getIme());
                    poruka.setEmail(novaPoruka.getEmail());
                    poruka.setTekst(novaPoruka.getTekst());
                    porukaRepository.save(poruka);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> dodajPoruku(@RequestBody Poruka novaPoruka) {
        novaPoruka.setPoslatoAt(LocalDateTime.now());
        Poruka sacuvanaPoruka = porukaRepository.save(novaPoruka);
        return ResponseEntity.ok(sacuvanaPoruka);
    }

}