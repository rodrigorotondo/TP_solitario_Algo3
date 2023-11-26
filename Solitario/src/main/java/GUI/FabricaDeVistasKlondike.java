package GUI;

import Solitario.Solitario;

public class FabricaDeVistasKlondike implements FabricaDeVistas{

    @Override
    public Vista crearVista(Solitario klondike) {
        return new VistaKlondike(klondike);
    }
}
