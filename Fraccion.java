/**
 * Clase que representa una fracción
 */
public class Fraccion {
  
  private int signo;
  private int numerador;
  private int denominador;

    /**
     * Contructor de fracción con numerador y denominador
     * @param n el numerador de la fracción
     * @param d el denominador de la fracción, no puede tener valor 0
     */
    public Fraccion(int n, int d) {
    if (d == 0) {
      System.out.println("Una fracción no puede tener como denominador el número 0");
    } else {
      if (n * d < 0) {
        this.signo = -1;
      } else {
        this.signo = 1;
      }
      this.numerador = Math.abs(n);
      this.denominador = Math.abs(d);
    }
  }
  /**
   * Obtiene el numerador de la fracción.
   * @return el numerador de la fracción
   */

  int getNumerador(){
    return this.numerador;
  }
  /**
   * Obtiene el denominador de la fracción.
   * @return el denominador de la fracción
   */
  int getDenominador(){
    return this.denominador;
  }
  /**
   * Devuelve una representación en forma de cadena de la fracción.
   * @return una cadena que representa la fracción en formato "numerador/denominador"
   */
  public String toString() {
    if (signo == -1) {
      return "-" + this.numerador + "/" + this.denominador;
    } else {
      return this.numerador + "/" + this.denominador;
    }
  }
  /**
   * Invierte la fracción.
   * @return una nueva fracción que es la inversa de la fracción original
   */
  public Fraccion invierte() {
    return new Fraccion(this.signo * this.denominador, this.numerador);
  }

  /**
   * Multiplica la fracción por un entero.
   * @param n el entero por el cual se multiplica la fracción
   * @return una nueva fracción que es el producto de la fracción original y el entero dado
   */
  public Fraccion multiplica(int n) {
    return new Fraccion(this.signo * this.numerador * n, this.denominador);
  }

  public Fraccion multiplica(Fraccion f) {
    return new Fraccion(
      this.signo * this.numerador * f.getNumerador(),
      this.denominador * f.getDenominador());
  }


  public Fraccion divide(int n) {
    return new Fraccion(this.signo * this.numerador, this.denominador * n);
  }

  public Fraccion divide(Fraccion f) {
    return new Fraccion(
      this.signo * this.numerador * f.getDenominador(),
      denominador * f.getNumerador());
  }

    
  public Fraccion simplifica() {
    
    final int s = this.signo;
    int n = this.numerador;
    int d = this.denominador;
      
    for (int i = 2; i < Math.min(this.numerador, this.denominador); i++) {
      while (((n % i) == 0) && ((d % i) == 0)) {
        n /= i;
        d /= i;
      }
    }

    return new Fraccion(s * n, d);
  }
}
