package com.arkon.pipeline.v1.model;

import lombok.*;

import javax.persistence.*;
/**
 * La clase Información es la forma final de representación de los datos, los cuales necesitan ser limpiados
 * para obtener la información necesaria para este proyecto.
 *
 * La anotación @Entity permite mapear la información para almacenarla en una base de datos mediante JPA
 * La anotación @Data permite generar los métodos Get, Set, toString, Hash, etc. de forma automática
 * La anotación @NoArgsConstructor genera un constructor sin parámetros
 * La anotación @AllArgsConstructor genera un constructor con la inicialización de las variables
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String alcaldia;
    private Double latitud;
    private Double longitud;
    private Integer idVehiculo;
    private Boolean statusVehiculo;
}
