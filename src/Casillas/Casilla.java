package Casillas;

/*
 * Clase que se encarga de crear las casillas del tablero, sirve de modelo para las casillas
 */
public class Casilla {

  private char tipo;

  private String nombre;

  /*
   * Constructor de la clase
   * @param tipo Tipo de casilla
   * @param nombre Nombre de la casilla
   */
  public Casilla(char tipo, String nombre) {
    this.tipo = tipo;
    this.nombre = nombre;
  }

  public char getTipo() {
    return this.tipo;
  }

  public void setTipo(char tipo) {
    this.tipo = tipo;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
