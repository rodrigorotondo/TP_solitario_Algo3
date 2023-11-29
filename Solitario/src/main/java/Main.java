
import GUI.MenuPrincipal;
import javafx.application.Application;


import static ManejoDeArchivos.ManejoDeArchivos.existeArchivo;
import static ManejoDeArchivos.ManejoDeArchivos.obtenerPathRaiz;
import static javafx.application.Application.launch;

public class Main{
public static void main(String[]args){



    Application.launch(MenuPrincipal.class,args);
    //System.out.println(obtenerPathRaiz() + "/Solitario/Klondike");
        }


    }
