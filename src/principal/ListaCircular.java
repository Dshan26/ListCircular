package principal;

public class ListaCircular implements ImplCircu {
    private Nodo primero;

    private static class Nodo {
        private final int valor;
        private Nodo siguiente;

        public Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public ListaCircular() {
        primero = null;
    }

    @Override
    public void agregar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (primero == null) {
            primero = nuevoNodo;
            primero.siguiente = primero;
        } else {
            Nodo ultimo = primero;
            if( valor < primero.valor) {
                if (ultimo.siguiente != primero) do {
                    ultimo = ultimo.siguiente;
                } while (ultimo.siguiente != primero);
                nuevoNodo.siguiente = primero;
                primero = nuevoNodo;
                ultimo.siguiente = primero;
            }else {
                Nodo actual = primero.siguiente;
                while (actual != primero && actual.valor < valor) {
                    ultimo = actual;
                    actual = actual.siguiente;
                }
                ultimo.siguiente = nuevoNodo;
                nuevoNodo.siguiente = actual;
            }
        }
    }

    @Override
    public void imprimir() {
        if (primero == null) {
            System.out.println("La lista está vacía");
        } else {
            Nodo actual = primero;
            do {
                System.out.print(actual.valor + " ");
                actual = actual.siguiente;
            } while (actual != primero);
            System.out.println();
        }
    }
}
