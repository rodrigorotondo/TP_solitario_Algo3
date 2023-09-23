import java.util.Stack;

public class Reglas {

    public void AgregarCartaOPilaDeCartaAColumna(Stack<Carta> pilaDeCartas, ColumnaDeJuego columnaDeJuego){

    }

    public boolean PuedoAgregarCarta(Carta carta, Fundacion fundacion){
        if(fundacion.estaVacia()){
            return carta.ObtenerNumero() == 1; // si la carta es igual a 1 devuelve true

        } else {
            return(carta.ObtenerNumero() == (fundacion.verUltimaCarta().ObtenerNumero() + 1) && carta.ObtenerPalo() == fundacion.verUltimaCarta().ObtenerPalo());

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

//nombres de "partes" que me parecen mas acordes
//1. fundacion (donde apilamos en orden)
//2. tablero (en vez de columnas de juego)
//3. deposito (el mazo de cartas que se encuentra en la parte sup. izquierda)
//4. descarte (las cartas que van saliendo del deposito)