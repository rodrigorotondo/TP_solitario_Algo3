import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class ColumnaDeJuego extends StackDeCartas{
    public ColumnaDeJuego(){
        this.cartas = new Stack<>();
    }
   /* public boolean columnaEnSecuenciaNumericaDescendenteAlternada(){
        //si la  columna tiene 0 o 1 elemento TA ORDENADA
        if (this.columna.size() < 2){
            return true;
        }
        //sino me hago una copia y la vacio y voy comparando entre pares de cartas:3
        Stack<Carta> copia = new Stack<>();
        ArrayList<Carta> listaAuxiliar = new ArrayList<>(this.columna);
        Collections.reverse(listaAuxiliar);
        copia.addAll(listaAuxiliar);
        //tengo mi copia de la columna (q feo queda >c)
        //esto termino siendo un ejercicio de algo2 (feo)
        Carta aComparar = copia.pop();
        while (!copia.empty()){
            Carta actual = copia.pop();
            if (actual.esPosterior(aComparar)|| !actual.MismoColorConOtraCarta(aComparar)){
                return false;
            }
            aComparar = actual;
        }
        return true;
    }*/
}
