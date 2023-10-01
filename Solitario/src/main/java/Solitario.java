public abstract class Solitario{
    protected int puntos;
    protected Reglas reglas;
    protected Mazo mazo;
    protected Fundacion[] fundaciones;
    protected Descarte descarte;
    protected ColumnaDeJuego[] tablero;

    public abstract void juegoAPuntoDeGanar();

}
