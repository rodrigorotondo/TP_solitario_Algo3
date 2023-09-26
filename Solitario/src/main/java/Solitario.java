import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solitario{
    private int puntos;
    private Reglas reglas;
    protected Mazo mazo;
    protected Fundacion[] fundaciones;
    protected Descarte descarte;
    protected ColumnaDeJuego[] tablero;
    private void IniciarFundaciones(int CantidadDeFundaciones){
        fundaciones = new Fundacion[CantidadDeFundaciones];
        for (int i = 0; i < CantidadDeFundaciones; i++){
            fundaciones[i] = new Fundacion();
        }
    }
    private void IniciarTablero(int CantidadDeColumnas, int[] CantidadDeCartasPorColumna, StackDeCartas mazo){
        tablero = new ColumnaDeJuego[CantidadDeColumnas];
        for (int i = 0; i < CantidadDeColumnas; i++){
            tablero[i] = new ColumnaDeJuego();
            for (int j = 0; j < CantidadDeCartasPorColumna[i]; j++){
                tablero[i].agregarCarta(mazo.robarUltimaCarta());
            }
            tablero[i].DarVueltaUltimaCarta();
        }
    }
    protected void IniciarMesa(){
        mazo = new Mazo();
        mazo.mezclarMazo();
        IniciarFundaciones(4);
        IniciarTablero(7, new int[]{1, 2, 3, 4, 5, 6, 7}, mazo);
        descarte = new Descarte();
    }
    protected void IniciarMesa(ColumnaDeJuego[] columnasEmpezadas,
           Fundacion[] fundacionesEmpezadas, Mazo mazoRestante, Descarte descarteEmpezado){
        mazo = mazoRestante;
        tablero = columnasEmpezadas;
        fundaciones = fundacionesEmpezadas;
        descarte = descarteEmpezado;
    }

    private boolean ganoSolitario(){
        return true;
    }
}
