import Solitario.*;
import org.junit.Test;
import utils.FreeCellTestingUtils;

import static org.junit.Assert.*;

public class FreeCellTest {
    @Test
    public void freeCellInicializacionEnEstadoAPuntoDeGanar() {
        FreeCellTestingUtils freeCell = new FreeCellTestingUtils();
        freeCell.juegoAPuntoDeGanarConCartaEnColumna();
        assertFalse(freeCell.juegoTerminado());
    }
    @Test
    public void freeCellJuegoGanado() {

        FreeCellTestingUtils freeCell = new FreeCellTestingUtils();
        freeCell.juegoAPuntoDeGanarConCartaEnColumna();
        freeCell.jugadaColumnaAFundacion(0, 3);
        assertTrue(freeCell.juegoTerminado());
    }
    @Test
    public void freeCellMovimientoDesdeColumnaVacia() {
        FreeCellTestingUtils freeCell = new FreeCellTestingUtils();
        freeCell.juegoAPuntoDeGanarConCartaEnColumna();
        freeCell.jugadaColumnaAFundacion(4, 3);
        assertFalse(freeCell.juegoTerminado());
    }
    @Test
    public void freeCellMovimientoDesdeAuxiliar() {
        FreeCellTestingUtils freeCell = new FreeCellTestingUtils();
        freeCell.juegoAPuntoDeGanarConCartaEnAuxiliar();
        freeCell.jugadaAuxiliarAFundacion(0, 3);
        assertTrue(freeCell.juegoTerminado());
    }
    @Test
    public void freeCellVariosMovimientos() throws Exception {
        FreeCellTestingUtils freeCell = new FreeCellTestingUtils();
        freeCell.juegoCasiGanado();
        freeCell.jugadaColumnaAColumna(6, 0, 1);
        freeCell.jugadaColumnaAAuxiliar(6, 2);
        freeCell.jugadaAuxiliarAColumna(2, 6);
        freeCell.jugadaColumnaAAuxiliar(6, 2);
        freeCell.jugadaColumnaAFundacion(0,3);
        freeCell.jugadaAuxiliarAFundacion(2, 3);
        assertTrue(freeCell.juegoTerminado());
    }

    @Test
    public void freeCellGuardarYCargarEstado() throws Exception {
        //arrange
        FreeCellTestingUtils freeCell = new FreeCellTestingUtils();
        VisitorSerializador serializador = new SerializadorSolitario();
        freeCell.juegoAPuntoDeGanarConCartaEnAuxiliar();
        freeCell.jugadaAuxiliarAColumna(0,0);

        Solitario freeCellCargado;
        //act
        freeCell.guardarEstado("testGuardadoFreecell",serializador);

        freeCellCargado = FreeCell.cargarEstado("testGuardadoFreecell",serializador);

        freeCellCargado.jugadaColumnaAFundacion(0,3);

        //assert
        assertTrue(freeCellCargado.juegoTerminado());




    }
}