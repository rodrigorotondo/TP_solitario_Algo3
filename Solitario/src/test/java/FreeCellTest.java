import Solitario.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreeCellTest {
    @Test
    public void freeCellInicializacionEnEstadoAPuntoDeGanar() {
        FabricaDeSolitarios fabricaFreecell = new FabricaDeSolitariosFreeCell();
        Solitario freeCell = fabricaFreecell.crearSolitario();
        freeCell.juegoAPuntoDeGanarConCartaEnColumna();
        assertFalse(freeCell.juegoTerminado());
    }
    @Test
    public void freeCellJuegoGanado() {
        FabricaDeSolitarios fabricaFreecell = new FabricaDeSolitariosFreeCell();
        Solitario freeCell = fabricaFreecell.crearSolitario();
        freeCell.juegoAPuntoDeGanarConCartaEnColumna();
        freeCell.jugadaColumnaAFundacion(0, 3);
        assertTrue(freeCell.juegoTerminado());
    }
    @Test
    public void freeCellMovimientoDesdeColumnaVacia() {
        FabricaDeSolitarios fabricaFreecell = new FabricaDeSolitariosFreeCell();
        Solitario freeCell = fabricaFreecell.crearSolitario();
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

    @Test
    public void freeCellGuardarYCargarEstado() throws Exception {
        //arrange
        FabricaDeSolitariosFreeCell fabricaFreeCell = new FabricaDeSolitariosFreeCell();
        FreeCell freeCell = fabricaFreeCell.crearSolitario();
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