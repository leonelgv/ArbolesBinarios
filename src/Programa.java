import javax.swing.*;
import java.util.Stack;

public class Programa {
    public static void main(String[] args){
        int opcion=0, elemento;
        String nombre;
        Arbol arbol = new Arbol();
        do{
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar un Nodo\n"
                                + "2. Recorrer el árbol InOrden\n"
                                + "3. Recorrer el árbol PreOrden\n"
                                + "4. Recorrer el árbol PostOrden\n"
                                + "5. Buscar un nodo en el árbol\n"
                                + "6. Eliminar un nodo del árbol\n"
                                + "7. Salir\n"
                                + "Elige una opción...",
                        "Árboles binarios",JOptionPane.QUESTION_MESSAGE));
                switch (opcion){
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el número del nodo...","Agregando nodo",
                                JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null,
                                "Ingresa el nombre del nodo...","Agregando nodo",
                                JOptionPane.QUESTION_MESSAGE);
                        arbol.agregarNodo(elemento, nombre);
                        break;
                    case 2:
                        if(!(arbol.estaVacio())){
                            System.out.println();
                            arbol.inOrden(arbol.raiz);
                        } else{
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        if(!(arbol.estaVacio())){
                            System.out.println();
                            arbol.preOrden(arbol.raiz);
                        } else{
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        if(!(arbol.estaVacio())){
                            System.out.println();
                            arbol.postOrden(arbol.raiz);
                        } else{
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 5:
                        if(!(arbol.estaVacio())){
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el número del nodo buscado...","Buscando nodo",
                                    JOptionPane.QUESTION_MESSAGE));
                            if(arbol.buscarNodo(elemento) == null){
                                JOptionPane.showMessageDialog(null, "Nodo no se encuentra en el árbol",
                                        "Nodo no encontrado", JOptionPane.INFORMATION_MESSAGE);
                            } else{
                                System.out.println("Nodo encontrado, sus datos son: " + arbol.buscarNodo(elemento));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6:
                        if(!(arbol.estaVacio())){
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el número del nodo a eliminar...","Eliminando nodo",
                                    JOptionPane.QUESTION_MESSAGE));
                            if(arbol.eliminar(elemento) == false){
                                JOptionPane.showMessageDialog(null, "Nodo no se encuentra en el árbol",
                                        "Nodo no encontrado", JOptionPane.INFORMATION_MESSAGE);
                            } else{
                                JOptionPane.showMessageDialog(null, "El nodo ha sido eliminado del árbol",
                                        "Nodo eliminado", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El árbol está vacío",
                                    "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Aplicación finalizada",
                                "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta","Cuidado",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;

                }
            } catch (NumberFormatException n){
                JOptionPane.showMessageDialog(null,"Error " + n.getMessage());
            }
        } while(opcion!=7);
    }
}
