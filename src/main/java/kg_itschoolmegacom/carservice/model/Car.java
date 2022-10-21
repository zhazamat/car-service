package kg_itschoolmegacom.carservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;//tayota
    private String model;//camry
    private int year;
    private double volume;
    private String color;
    private Double cost;
    private  Integer horsePower;

}
