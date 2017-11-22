public class Arbol {
    Nodo raiz;

    public Arbol(){
        raiz = null;
    }

    // Método para insertar un nodo en el arbol

    public void agregarNodo(int valor, String nombre){
        Nodo nuevo = new Nodo(valor, nombre);
        // Si raiz esta vacio, nuevo es igual a raiz
        if(raiz == null){
            raiz = nuevo;
        } else {
            // Nodo auxiliar que apunta a raiz
            Nodo auxiliar = raiz;
            // Nodo padre es null
            Nodo padre;
            while(true){
                //Padre apunta a la raiz
                padre = auxiliar;
                // Si el dato es menor
                if(valor<auxiliar.valor){
                    auxiliar = auxiliar.hojaIzquierda;
                    if(auxiliar==null){
                        padre.hojaIzquierda = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.hojaDerecha;
                    if(auxiliar==null){
                        padre.hojaDerecha=nuevo;
                        return;
                    }
                }
            }
        }
    }

    //Método para saber cual el árbol está vacio
    public boolean estaVacio(){
        return raiz==null;
    }

    //Método para recorrer el árbol InOrden
    public void inOrden(Nodo raiz){
        if(raiz!=null){
            inOrden(raiz.hojaIzquierda);
            System.out.println(raiz.valor);
            inOrden(raiz.hojaDerecha);
        }
    }

    //Método para recorrer el árbol PreOrden
    public void preOrden(Nodo raiz){
        if(raiz!=null){
            System.out.println(raiz.valor);
            preOrden(raiz.hojaIzquierda);
            preOrden(raiz.hojaDerecha);
        }
    }

    //Método para recorrer el árbol PostOrden
    public void postOrden(Nodo raiz){
        if(raiz!=null){
            postOrden(raiz.hojaIzquierda);
            postOrden(raiz.hojaDerecha);
            System.out.println(raiz.valor);
        }
    }
}
