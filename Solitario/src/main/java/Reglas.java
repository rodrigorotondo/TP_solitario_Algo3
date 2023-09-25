public class Reglas {

    public boolean PuedoSacarCartaDelDeposito(Mazo mazo){
        if (mazo.estaVacia()){
            return false;
        }
        return true;
    }
    public boolean PuedoAgregarCartasAColumna(StackDeCartas pilaDeCartas, ColumnaDeJuego columnaDeJuego){
        if(columnaDeJuego.estaVacia()){
            return pilaDeCartas.verUltimaCarta().esUnRey(); // si la carta es igual a 1 devuelve true
        } else {
            return(columnaDeJuego.verUltimaCarta().esPosterior(pilaDeCartas.verUltimaCarta()) &&
            !columnaDeJuego.verUltimaCarta().MismoColorConOtraCarta(pilaDeCartas.verUltimaCarta()));
        }
    }
    public boolean PuedoAgregarCarta(Carta carta, Fundacion fundacion){
        if(fundacion.estaVacia()){
            return carta.esUnAs(); // si la carta es igual a 1 devuelve true
        } else {
            return(carta.esPosterior(fundacion.verUltimaCarta()) && carta.esMismoPalo(fundacion.verUltimaCarta()));
        }
    }
    public boolean PuedoAgregarCarta(Carta carta, ColumnaDeJuego columna){
        if(columna.estaVacia()){
            return carta.esUnRey(); // si la carta es igual a 13 devuelve true

        } else {
            return(carta.esAnterior(columna.verUltimaCarta()) && !(carta.EsMismoColorConOtraCarta(columna.verUltimaCarta())));
        }
    }
}
//REGLAS en solitario Klondike
//1. en la columna de juego podemos mover cartas de 1 columna hacia otra
//2. las cartas en las columnas deberan ubicarse en orden DESCENDENTE y deben alternar su color
//3. tambien se pueden mover conjuntos SECUENCIALES de cartas entre columnas
//4. si hay alguna columna vacia, se puede ubicar una K o cualquier conjunto secuencial que comience con ella
//5. si quiero mas cartas, pido en el deposito (puedo ver hasta 3 cartas). Si presiono nuevamente se da vuelta
//al deposito y me entrega las cartas nuevamente
