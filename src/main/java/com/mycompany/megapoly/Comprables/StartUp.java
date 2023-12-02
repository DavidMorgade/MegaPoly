package com.mycompany.megapoly.Comprables;

public class StartUp extends Comprable {

  public StartUp(
    int precio,
    int alquiler,
    String nombreComprable,
    String descripcion
  ) {
    super(precio, alquiler, nombreComprable, descripcion);
  }

  public void alquilerConDosStartUp() {
    this.alquiler = this.alquiler * 2;
  }
}
