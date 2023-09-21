import java.util.ArrayList;
import java.util.Stack;

public class Solitario{
    private int puntos;
    private Reglas reglas;
    private Mazo mazo;
    private ArrayList<Fundacion> fundaciones;
    private Descarte descarte;
    private ArrayList<ColumnaDeJuego> tablero;

    private void CrearFundaciones(int cantidadDeFundaciones) {
        fundaciones = new Fundacion[cantidadDeFundaciones]; //NOOOOOO
    }
}
