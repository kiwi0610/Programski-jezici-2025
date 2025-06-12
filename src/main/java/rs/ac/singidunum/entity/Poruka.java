package rs.ac.singidunum.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "poruka")
@NoArgsConstructor
@Getter
@Setter
public class Poruka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poruka_id")
    private Integer id;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String tekst;

    @Column(nullable = false)
    private LocalDateTime poslatoAt;


}