import java.util.ArrayList;
import java.util.Stack;

public class Solitario{
    private int puntos;
    private Reglas reglas;
    private Mazo mazo;
    private Fundacion[] fundaciones;
    private Descarte descarte;
    private ColumnaDeJuego[] tablero;

    private void IniciarFundaciones(int CantidadDeFundaciones){
        fundaciones = new Fundacion[CantidadDeFundaciones];
        for (int i = 0; i < CantidadDeFundaciones; i++){
            fundaciones[i] = new Fundacion();
        }
    }
//{1,2,3,4,5,6,7} hago los tama;os de las columnas con el
    private void IniciarTablero(int CantidadDeColumnas, int[] CantidadDeCartasPorColumna){
        tablero = new ColumnaDeJuego[CantidadDeColumnas];
        for (int i = 0; i < CantidadDeColumnas; i++){
            tablero
        }

    }
}
