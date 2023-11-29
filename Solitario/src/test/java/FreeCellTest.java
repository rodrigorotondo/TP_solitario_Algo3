import Excepciones.ExcepcionAuxiliarVacio;
import Excepciones.ExcepcionMoverColumnaVacia;
import Excepciones.ExcepcionNoPuedoAgregarCarta;
import Solitario.*;
import org.junit.Test;
import utils.FreeCellTestingUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class FreeCellTest {
    @Test
    public void freeCellInicializacionEnEstadoAPuntoDeGanar() {
        FreeCellTestingUtils freeCell = new FreeCellTestingUtils();
        freeCell.juegoAPuntoDeGanarConCartaEnColumna();
        assertFalse(freeCell.juegoTerminado());
    }
    @Test
    public void freeCellJuegoGanado() throws ExcepcionMoverColumnaVacia, ExcepcionNoPuedoAgregarCarta {

        FreeCellTestingUtils freeCell = new FreeCellTestingUtils();
        freeCell.juegoAPuntoDeGanarConCartaEnColumna();
        freeCell.jugadaColumnaAFundacion(0, 3);
        assertTrue(freeCell.juegoTerminado());
    }
    @Test
    public void freeCellMovimientoDesdeColumnaVacia() throws ExcepcionMoverColumnaVacia, ExcepcionNoPuedoAgregarCarta {
        FreeCellTestingUtils freeCell = new FreeCellTestingUtils();
        freeCell.juegoAPuntoDeGanarConCartaEnColumna();
        freeCell.jugadaColumnaAFundacion(4, 3);
        assertFalse(freeCell.juegoTerminado());
    }
    @Test
    public void freeCellMovimientoDesdeAuxiliar() throws ExcepcionAuxiliarVacio, ExcepcionNoPuedoAgregarCarta {
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
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        freeCell.guardarEstado(serializador, bytes);

        freeCellCargado = FreeCell.cargarEstado(serializador, new ByteArrayInputStream(bytes.toByteArray()));

        freeCellCargado.jugadaColumnaAFundacion(0,3);

        //assert
        assertTrue(freeCellCargado.juegoTerminado());
    }
}
