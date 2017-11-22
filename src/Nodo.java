public class Nodo {
    int valor;
    String nombre;
    Nodo hojaIzquierda;
    Nodo hojaDerecha;

    /* Constructor */
    public Nodo(int valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
        this.hojaIzquierda = null;
        this.hojaDerecha = null;
    }

    public String toString(){
        return nombre + " su valor es " + valor ;
    }
}
