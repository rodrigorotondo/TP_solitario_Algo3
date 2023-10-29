package Solitario;

import Reglas.ReglasFreeCell;
import Reglas.ReglasKlondike;
import StackDeCartas.Mazo;

public class FabricaDeSolitarios {

    public static Klondike CrearKlondike(){
        final int CANTIDADDEFUNDACIONES = 4;
        final int CANTIDADDECOLUMNAS = 7;
        Mazo mazo = new Mazo();
        ReglasKlondike reglas = new ReglasKlondike();
        return new Klondike(mazo,reglas,CANTIDADDEFUNDACIONES,CANTIDADDECOLUMNAS);
    }

    public static FreeCell crearFreecell(){
        final int CANTIDADDEFUNDACIONES = 4;
        final int CANTIDADDECOLUMNAS = 8;
        Mazo mazo = new Mazo();
        ReglasFreeCell reglas = new ReglasFreeCell();
        return new FreeCell(mazo,reglas,CANTIDADDEFUNDACIONES,CANTIDADDECOLUMNAS);
    }

}
