package Materiales;

/*
 * Clase que se encarga de crear los dados del juego
 * @see Dado
 */
public class Dado {

  private int numero;

  /*
   * Constructor de la clase
   * @param numero Numero del dado
   */
  public Dado() {
    this.numero = 0;
  }

  public int getNumero() {
    return this.numero;
  }

  public void setNumeroAleatorio() {
    this.numero = this.generarNumero();
  }

  /*
   * Metodo que genera un numero aleatorio entre 1 y 6
   * @return Numero aleatorio
   */
  private int generarNumero() {
    return (int) (Math.random() * 6 + 1);
  }
}
