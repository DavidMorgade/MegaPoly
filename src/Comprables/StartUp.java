package Comprables;

/*
 * Clase que se encarga de crear las casillas de startUp del tablero
 * @see Casilla
 */
public class StartUp extends Comprable {

  /*
   * Constructor de la clase
   * @param precio Precio de la propiedad
   * @param alquiler Alquiler de la propiedad
   * @param nombreComprable Nombre de la propiedad
   * @param descripcion Descripcion de la propiedad
   */
  public StartUp(
    int precio,
    int alquiler,
    String nombreComprable,
    String descripcion
  ) {
    super(precio, alquiler, nombreComprable, descripcion);
  }

  /*
   * Metodo que se encarga de cambiar el alquiler de la startup en caso de que tenga dos startups
   */
  public void alquilerConDosStartUp() {
    this.alquiler = this.alquiler * 2;
  }
}
