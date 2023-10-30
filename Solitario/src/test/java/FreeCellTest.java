import Solitario.FabricaDeSolitarios;
import Solitario.FreeCell;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreeCellTest {
    @Test
    public void freeCellInicializacionEnEstadoAPuntoDeGanar() {
        FreeCell freeCell = FabricaDeSolitarios.crearFreecell();
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
    @Test
    public void freeCellVariosMovimientos() throws Exception {
        FreeCell freeCell = new FreeCell();
        freeCell.juegoCasiGanado();
        freeCell.jugadaColumnaAColumna(6, 0, 1);
        freeCell.jugadaColumnaAAuxiliar(6, 2);
        freeCell.jugadaAuxiliarAColumna(2, 6);
        freeCell.jugadaColumnaAAuxiliar(6, 2);
        freeCell.jugadaColumnaAFundacion(0,3);
        freeCell.jugadaAuxiliarAFundacion(2, 3);
        assertTrue(freeCell.juegoTerminado());
    }
}