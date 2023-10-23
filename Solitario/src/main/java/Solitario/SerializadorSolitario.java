package Solitario;

import java.io.*;

public class SerializadorSolitario implements VisitorSerializador{

    @Override
    public void guardarEstado(Solitario solitario, String nombreArchivo) throws IOException {
        ObjectOutputStream solitarioSalida = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nombreArchivo)));
        solitarioSalida.writeObject(solitario);
        solitarioSalida.close();
    }
    @Override
    public Klondike cargarEstadoKlondike(String nombreArchivo) throws IOException, ClassNotFoundException {
        ObjectInputStream Entrada = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nombreArchivo)));
        Klondike klondike = (Klondike) Entrada.readObject();
        Entrada.close();
        return klondike;
    }


}
