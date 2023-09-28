public class ReglasKlondike extends Reglas {
    public boolean PuedoSacarCartaDelMazo(Mazo mazo){return !mazo.estaVacia();}
    public boolean PuedoSacarCartaDelDescarte(Descarte descarte){return !descarte.estaVacia();}
    public boolean PuedoAgregarCartasAColumna(ColumnaDeJuego columnaExtraer, ColumnaDeJuego columnaDepositar){
        if(columnaDepositar.estaVacia()){
            return columnaExtraer.obtenerNumeroPrimeraCarta() == REY;
        } else {
            return(columnaExtraer.obtenerNumeroPrimeraCarta() < columnaDepositar.obtenerNumeroUltimaCarta()) &&
                    columnaExtraer.obtenerColorPrimeraCarta() != columnaDepositar.obtenerColorUltimaCarta();
        }
    }
    public boolean PuedoAgregarCarta(Carta carta, Fundacion fundacion){
        if(fundacion.estaVacia()){
            return carta.obtenerNumero() == AS; // si la carta es igual a 1 devuelve true
        } else {
            return(carta.esPosterior(fundacion.verUltimaCarta()) && carta.esMismoPalo(fundacion.verUltimaCarta()));
        }
    }
    public boolean PuedoAgregarCarta(Carta carta, ColumnaDeJuego columna){
        if(columna.estaVacia()){
            return carta.obtenerNumero() == REY; // si la carta es igual a 13 devuelve true
        } else {
            return(carta.obtenerNumero() < columna.obtenerNumeroUltimaCarta() && (carta.obtenerColor() != columna.obtenerColorUltimaCarta()));
        }
    }
}
