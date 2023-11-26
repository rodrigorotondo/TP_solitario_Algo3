package GUI;

import Solitario.Solitario;

public class FabricaDeVistasFreeCell implements FabricaDeVistas{
    @Override
    public VistaFreeCell crearVista(Solitario freeCell) {
        return new VistaFreeCell(freeCell);
    }
}
