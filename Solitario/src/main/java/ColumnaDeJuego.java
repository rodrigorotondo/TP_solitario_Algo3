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
    public int obtenerTamanio(){
        return cartas.size();
    }
    public Color obtenerColorPrimeraCarta(){
        return obtenerPrimeraCarta().obtenerColor();
    }

    public int obtenerNumeroPrimeraCarta(){
        return obtenerPrimeraCarta().obtenerNumero();
    }

    public int obtenerNumeroUltimaCarta(){
        return obtenerUltimaCarta().obtenerNumero();
    }

    public Color obtenerColorUltimaCarta(){
        return obtenerUltimaCarta().obtenerColor();
    }
    public Palo obtenerPaloUltimaCarta(){
        return obtenerUltimaCarta().obtenerPalo();
    }
    public void darVueltaUltimaCarta(){
        obtenerUltimaCarta().descubrirCarta();
    }
    private Carta obtenerPrimeraCarta(){
        return cartas.get(TOPE);
    }
    private Carta obtenerUltimaCarta(){
        return cartas.get(indiceUltimaCarta());
    }
    private int indiceUltimaCarta(){
        return (cartas.size()-1);
    }
    public void agregarCarta(Carta carta){
        this.cartas.add(carta);
    }
    private void eliminarCarta(Carta carta){
        this.cartas.remove(carta);
    }
    private void eliminarUltimaCarta(){
        int lastIndex = this.cartas.size() - 1;
        if (lastIndex >= 0) {
            this.cartas.remove(lastIndex);
        }
    }
    public void agregarCartas(ColumnaDeJuego cartasAAgregar){
        for(Carta carta: cartasAAgregar.cartas ){
            this.agregarCarta(carta);
        }
    }
    private void eliminarCartas(ColumnaDeJuego cartasAEliminar){
        for(Carta carta: cartasAEliminar.cartas ){
            this.eliminarCarta(carta);
        }
    }
    public void cambiarDeColumna(ColumnaDeJuego columnaDestino, int indiceCartaTopeQueMuevo){ //osea a partir de la cual quiero mover
        ColumnaDeJuego columnaAuxiliar = new ColumnaDeJuego();

        for(int nroCartaActual = indiceCartaTopeQueMuevo ; nroCartaActual < this.obtenerTamanio() ; nroCartaActual++){
            columnaAuxiliar.agregarCarta(this.cartas.get(nroCartaActual));
        }
        columnaDestino.agregarCartas(columnaAuxiliar);
        this.eliminarCartas(columnaAuxiliar);
    }
    public void cambiarAFundacion(Fundacion fundacionDestino){
        Carta cartaCopia = this.obtenerUltimaCarta();
        fundacionDestino.agregarCarta(cartaCopia);
        this.eliminarUltimaCarta();
    }
    public boolean esCartaVisible(int indiceCarta){
        return this.cartas.get(indiceCarta).esVisible();
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
