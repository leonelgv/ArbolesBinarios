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
            System.out.print(raiz.valor + ", ");
            inOrden(raiz.hojaDerecha);
        }
    }

    //Método para recorrer el árbol PreOrden
    public void preOrden(Nodo raiz){
        if(raiz!=null){
            System.out.print(raiz.valor + ", ");
            preOrden(raiz.hojaIzquierda);
            preOrden(raiz.hojaDerecha);
        }
    }

    //Método para recorrer el árbol PostOrden
    public void postOrden(Nodo raiz){
        if(raiz!=null){
            postOrden(raiz.hojaIzquierda);
            postOrden(raiz.hojaDerecha);
            System.out.print(raiz.valor + ", ");
        }
    }

    //Método para buscar un Nodo en el Árbol

    public Nodo buscarNodo(int d){
        Nodo aux = raiz;

        while(aux.valor!=d){
            if(d<aux.valor){
                aux = aux.hojaIzquierda;
            } else {
                aux = aux.hojaDerecha;
            }
            if(aux==null){
                return null;
            }
        }
        return aux;
    }

    public boolean eliminar(int d){
        Nodo auxiliar = raiz;
        Nodo padre = raiz;
        boolean esHijoIzq = true;
        while (auxiliar.valor!=d){
            padre = auxiliar;
            if(d<auxiliar.valor){
                esHijoIzq = true;
                auxiliar = auxiliar.hojaIzquierda;
            } else {
                esHijoIzq = false;
                auxiliar = auxiliar.hojaDerecha;
            }
            if(auxiliar==null){
                return false;
            }
        }//Fin del while
        if(auxiliar.hojaIzquierda == null && auxiliar.hojaDerecha == null){
            if(auxiliar == raiz){
                raiz = null;
            } else if(esHijoIzq){
                padre.hojaIzquierda = null;
            } else{
                padre.hojaDerecha = null;
            }
        } else if(auxiliar.hojaDerecha == null){
            if(auxiliar == raiz){
                raiz = auxiliar.hojaIzquierda;
            } else if (esHijoIzq){
                padre.hojaIzquierda = auxiliar.hojaIzquierda;
            } else {
                padre.hojaDerecha = auxiliar.hojaIzquierda;
            }
        } else if(auxiliar.hojaIzquierda == null){
            if(auxiliar == raiz){
                raiz = auxiliar.hojaDerecha;
            } else if (esHijoIzq){
                padre.hojaIzquierda = auxiliar.hojaDerecha;
            } else {
                padre.hojaDerecha = auxiliar.hojaIzquierda;
            }
        }else{
            Nodo reemplazo = obtenerNodoReemplazo(auxiliar);
            if(auxiliar==raiz){
                raiz = reemplazo;
            }else if(esHijoIzq){
                padre.hojaIzquierda = reemplazo;
            }else{
                padre.hojaDerecha = reemplazo;
            }
            reemplazo.hojaIzquierda = auxiliar.hojaIzquierda;
        }
        return true;
    }

    //Método encargado de devolvernos el nodo reemplazo

    public Nodo obtenerNodoReemplazo(Nodo nodoReemp){
        Nodo reemplazarPadre = nodoReemp;
        Nodo reemplazo = nodoReemp;
        Nodo auxiliar = nodoReemp.hojaIzquierda;
        while (auxiliar == null){
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.hojaIzquierda;
        }if(reemplazo!= nodoReemp.hojaDerecha){
            reemplazarPadre.hojaIzquierda = reemplazo.hojaDerecha;
            reemplazo.hojaDerecha = nodoReemp.hojaDerecha;
        }
        System.out.println("El nodo reemplazo es " + reemplazo);
        return reemplazo;

    }
}
