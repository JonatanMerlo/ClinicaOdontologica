package com.example.ClinicaOdontologica.entities;



import javax.persistence.*;


@Entity
@Table(name = "domicilios")
public class Domicilio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String provincia;
    @Column
    private String localidad;
    @Column
    private String calle;
    @Column
    private String numero;




    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }


}
