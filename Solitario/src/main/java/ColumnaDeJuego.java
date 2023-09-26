import java.util.ArrayList;


public class ColumnaDeJuego {
    private ArrayList<Carta> cartas;

    final private int TOPE = 0;
    public ColumnaDeJuego(){
        this.cartas = new ArrayList<>();
    }

    public boolean estaVacia(){
        return cartas.isEmpty();
    }

    public Color obtenerColorPrimeraCarta(){
        return obtenerPrimeraCarta().ObtenerColor();
    }

    public int obtenerNumeroPrimeraCarta(){
        return obtenerPrimeraCarta().ObtenerNumero();
    }

    public int obtenerNumeroUltimaCarta(){
        return obtenerUltimaCarta().ObtenerNumero();
    }

    public Color obtenerColorUltimaCarta(){
        return obtenerUltimaCarta().ObtenerColor();
    }

    private Carta obtenerPrimeraCarta(){
        return cartas.get(TOPE);
    }

    private Carta obtenerUltimaCarta(){
        return cartas.get(IndiceUltimaCarta());
    }

    private int IndiceUltimaCarta(){
        return cartas.size();
    }



    /*public boolean columnaEnSecuenciaNumericaDescendenteAlternada(){
        //si la  columna tiene 0 o 1 elemento TA ORDENADA
        if (this.cartas.size() < 2){
            return true;
        }
        //sino me hago una copia y la vacio y voy comparando entre pares de cartas:3
        Stack<Carta> copia = new Stack<>();
        ArrayList<Carta> listaAuxiliar = new ArrayList<>(this.cartas);
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
