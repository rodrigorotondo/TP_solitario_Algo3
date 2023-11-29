package ManejoDeArchivos;

import Solitario.*;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class ManejoDeArchivos {

    public static String obtenerCarpetaAssets(){
        Path directorioActualPath = FileSystems.getDefault().getPath("");
        return directorioActualPath.toAbsolutePath() + "/src/assets/";
    }
    public static String obtenerPathRaiz(){
        Path directorioActualPath = FileSystems.getDefault().getPath("");
        return directorioActualPath.toAbsolutePath().toString();
    }
    public static boolean existeArchivo(String path){
        File archivo = new File(path);
        return archivo.exists();
    }
    public static void guardarSolitario(Solitario solitario, String nombreArchivo) throws IOException {
        SerializadorSolitario serializador = new SerializadorSolitario();
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();

        solitario.guardarEstado(serializador,bytes);
        OutputStream solitarioSalida = new FileOutputStream(nombreArchivo);

        bytes.writeTo(solitarioSalida);
    }
    public static Klondike cargarSolitarioKlondike( String nombreArchivo) throws IOException, ClassNotFoundException {

        SerializadorSolitario serializador = new SerializadorSolitario();

        InputStream solitarioEntrada= new FileInputStream(nombreArchivo);

        return Klondike.cargarEstado(serializador, solitarioEntrada);
    }

    public static FreeCell cargarSolitarioFreecell( String nombreArchivo) throws IOException, ClassNotFoundException {

        SerializadorSolitario serializador = new SerializadorSolitario();

        InputStream solitarioEntrada= new FileInputStream(nombreArchivo);

        return FreeCell.cargarEstado(serializador, solitarioEntrada);
    }
}

