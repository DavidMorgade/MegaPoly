package com.mycompany.megapoly.Comprables;

public class Propiedad extends Comprable {

  public Propiedad(int precio, int alquiler, String nombreComprable) {
    super(precio, alquiler, nombreComprable);
  }

  public void alquilerConTresPropiedades() {
    this.alquiler = this.alquiler * 3;
  }

  public void alquilerConDosPropiedades() {
    this.alquiler = this.alquiler * 2;
  }

  public void alquilerConUnaPropiedad() {
    this.alquiler = this.alquiler / 3;
  }
}
