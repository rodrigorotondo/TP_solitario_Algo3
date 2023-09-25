public class Juego {
    private Solitario solitario;
    public void empezarJuego(){
        solitario.IniciarMesa();
    }
    public void empezarJuegoEnEstado(ColumnaDeJuego[] columnasEmpezadas, Fundacion[] fundacionesEmpezadas,
                                     Mazo mazoRestante, Descarte descarteEmpezado){
        solitario.IniciarMesa(columnasEmpezadas, fundacionesEmpezadas, mazoRestante, descarteEmpezado);
    }
}
