package Solitario;

import java.io.IOException;

public interface VisitorSerializador {
    public abstract Klondike cargarEstadoKlondike(String nombreArchivo) throws IOException, ClassNotFoundException;
    public abstract FreeCell cargarEstadoFreeCell(String nombreArchivo) throws IOException, ClassNotFoundException;
    public abstract void guardarEstado(Solitario solitario, String nombreArchivo) throws IOException;

}
