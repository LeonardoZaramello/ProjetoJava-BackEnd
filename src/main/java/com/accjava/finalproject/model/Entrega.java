package com.accjava.finalproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Entregas")
public class Entrega {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "latitude")
  private String latitude;

  @Column(name = "longitude")
  private String longitude;

  @Column(name = "status")
  private String status;

  @Column(name = "data_saida")
  private String dataSaida;

  @Column(name = "data_entrega")
  private String dataEntrega;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "drone_id")
  private Drone drone;

  public Entrega(){}

  public Entrega(Long id, String latitude, String longitude) {
    super();
    this.id = id;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  
  public String getDataSaida() {
    return dataSaida;
  }

  public void setDataSaida(String dataSaida) {
    this.dataSaida = dataSaida;
  }

  public String getDataEntrega() {
    return dataEntrega;
  }

  public void setDataEntrega(String dataEntrega) {
    this.dataEntrega = dataEntrega;
  }

  public Drone getDrone() {
    return drone;
  }

  public void setDrone(Drone drone) {
    this.drone = drone;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  
}
