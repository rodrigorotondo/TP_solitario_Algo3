import java.util.ArrayList;
import java.util.Stack;

public class Solitario{
    private int puntos;
    private Reglas reglas;
    private Mazo mazo;
    private Fundacion[] fundaciones;
    private Descarte descarte;
    private Deposito deposito;
    private ColumnaDeJuego[] tablero;
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
            for (int j = 0; j < CantidadDeCartasPorColumna[j]; j++){
                tablero[i].agregarCarta(mazo.robarUltimaCarta());
            }
            tablero[i].verUltimaCarta().DescubrirCarta();
        }
    }
    private void IniciarDeposito(StackDeCartas mazoYaRepartido){
        deposito = new Deposito();
        deposito.llenarDeposito(mazoYaRepartido);

    }
    private void IniciarMesa(){
        mazo = new Mazo();
        mazo.mezclarMazo();
        IniciarFundaciones(4);
        IniciarTablero(7, new int[]{1, 2, 3, 4, 5, 6, 7}, mazo);
        descarte = new Descarte();
    }
}
