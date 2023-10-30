package Solitario;

import java.io.IOException;

public interface VisitorSerializador {
    Klondike cargarEstadoKlondike(String nombreArchivo) throws IOException, ClassNotFoundException;
    FreeCell cargarEstadoFreeCell(String nombreArchivo) throws IOException, ClassNotFoundException;
    void guardarEstado(Solitario solitario, String nombreArchivo) throws IOException;

}
