public abstract class Solitario{
    protected Reglas reglas;
    protected Mazo mazo;
    protected Fundacion[] fundaciones;
    protected Descarte descarte;
    protected ColumnaDeJuego[] tablero;

    public abstract void juegoAPuntoDeGanarConCartaEnColumna();

    public abstract void juegoAPuntoDeGanarConCartaEnDescarte();



}
