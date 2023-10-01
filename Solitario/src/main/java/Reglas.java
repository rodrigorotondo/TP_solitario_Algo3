public abstract class Reglas {
    final protected int REY = 13;
    final protected int AS = 1;
    public abstract boolean puedoExtraerDeColumna(ColumnaDeJuego columna);
    public abstract boolean esCartaVisible(ColumnaDeJuego columaOrigen, int indiceCartaOrigen);
    public abstract boolean puedoSacarCartaDelMazo(Mazo mazo);
    public abstract boolean puedoSacarCartaDelDescarte(Descarte descarte);
    public abstract boolean puedoAgregarCartasAColumna(ColumnaDeJuego columnaExtraer, ColumnaDeJuego columnaDepositar);
    public abstract boolean puedoAgregarCarta(int numeroCarta, Palo paloCarta, Fundacion fundacion);
    public abstract boolean puedoAgregarCarta(int numeroCarta, Palo paloCarta, ColumnaDeJuego columna);
    public abstract boolean juegoGanado(Fundacion[] fundaciones);

}
//REGLAS en solitario Klondike
//1. en la columna de juego podemos mover cartas de 1 columna hacia otra
//2. las cartas en las columnas deberan ubicarse en orden DESCENDENTE y deben alternar su color
//3. tambien se pueden mover conjuntos SECUENCIALES de cartas entre columnas
//4. si hay alguna columna vacia, se puede ubicar una K o cualquier conjunto secuencial que comience con ella
//5. si quiero mas cartas, pido en el deposito (puedo ver hasta 3 cartas). Si presiono nuevamente se da vuelta
//al deposito y me entrega las cartas nuevamente
