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
    public boolean PuedoAgregarCarta(int numeroCarta, Palo paloCarta, Fundacion fundacion){
        if(fundacion.estaVacia()){
            return numeroCarta == AS; // si la carta es igual a 1 devuelve true
        } else {
            return(fundacion.verUltimaCarta().esAnterior(numeroCarta) && fundacion.verUltimaCarta().esMismoPalo(paloCarta));
        }
    }
    public boolean PuedoAgregarCarta(int numeroCarta, Palo paloCarta, ColumnaDeJuego columna){//columna a columna
        if(columna.estaVacia()){
            return numeroCarta == REY; // si la carta es igual a 13 devuelve true
        } else {
            return(numeroCarta < columna.obtenerNumeroUltimaCarta() && (paloCarta.obtenerColor() != columna.obtenerColorUltimaCarta()));
        }
    }
}
