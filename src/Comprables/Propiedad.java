package Comprables;

/*
 * Clase que se encarga de crear las propiedades del tablero
 * @see Comprable
 */
public class Propiedad extends Comprable {

  /*
   * Constructor de la clase
   * @param precio Precio de la propiedad
   * @param alquiler Alquiler de la propiedad
   * @param nombreComprable Nombre de la propiedad
   * @param descripcion Descripcion de la propiedad
   */
  public Propiedad(
    int precio,
    int alquiler,
    String nombreComprable,
    String descripcion
  ) {
    super(precio, alquiler, nombreComprable, descripcion);
  }

  /*
   * Metodo que se encarga de cambiar el alquiler de la propiedad en caso de que tenga todas las propiedades del mismo tipo
   */
  public void alquilerConTresPropiedades() {
    this.alquiler = this.alquiler * 3;
  }

  /*
   * Metodo que se encarga de cambiar el alquiler de la propiedad en caso de que tenga dos propiedades del mismo tipo
   */
  public void alquilerConDosPropiedades() {
    this.alquiler = this.alquiler * 2;
  }

  /*
   * Metodo que se encarga de cambiar el alquiler de la propiedad en caso de que tenga una propiedad del mismo tipo
   */
  public void alquilerConUnaPropiedad() {
    this.alquiler = this.alquiler / 3;
  }
}
