package ManejoDeArchivos;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class ManejoDeArchivos {

    public static String obtenerCarpetaAssets(){
        Path directorioActualPath = FileSystems.getDefault().getPath("");
        return directorioActualPath.toAbsolutePath() + "/src/assets/";
    }
}
