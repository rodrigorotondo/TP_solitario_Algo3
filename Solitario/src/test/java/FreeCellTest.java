import Solitario.FreeCell;
import Solitario.Klondike;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreeCellTest {
    @Test
    public void freeCellInicializacionEnEstadoAPuntoDeGanar() {

        FreeCell freeCell = new FreeCell();
        freeCell.juegoAPuntoDeGanarConCartaEnColumna();
        assertFalse(freeCell.juegoTerminado());
    }

    @Test
    public void freeCellJuegoGanado() {

        FreeCell freeCell = new FreeCell();
        freeCell.juegoAPuntoDeGanarConCartaEnColumna();
        freeCell.jugadaColumnaAFundacion(0, 3);
        assertTrue(freeCell.juegoTerminado());
    }

    @Test
    public void freeCellMovimientoDesdeColumnaVacia() {

        FreeCell freeCell = new FreeCell();
        freeCell.juegoAPuntoDeGanarConCartaEnColumna();
        freeCell.jugadaColumnaAFundacion(4, 3);
        assertFalse(freeCell.juegoTerminado());
    }



    @Test
    public void freeCellMovimientoDesdeAuxiliar() {
        FreeCell freeCell = new FreeCell();
        freeCell.juegoAPuntoDeGanarConCartaEnAuxiliar();
        freeCell.jugadaAuxiliarAFundacion(0, 3);
        assertTrue(freeCell.juegoTerminado());
    }

}