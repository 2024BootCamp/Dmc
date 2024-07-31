package com.dmc.bootcamp.domain;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
=======

>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<< HEAD
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "meal")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foodName;
    private double quantity;

    @ManyToOne
    private AppUser user;
=======
@Getter
@Setter
@NoArgsConstructor
public class Meal {
    private String foodName;
    private float quantity;
>>>>>>> 235a33fcc00776f3ec31e1eb0513a0160fbc4608
}
