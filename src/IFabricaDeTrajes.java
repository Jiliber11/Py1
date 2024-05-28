import java.util.ArrayList;

public interface IFabricaDeTrajes {
    void añadirComponenteAAlmacen() throws IdException, MuchoExtracomunitarioException, MangaException;
    void listarComponentes();
    void añadirTrajeAAlmacen() throws ColoresException, TallaException, TrajeYaExisteException;
    void listarTrajes();
    void activarDesactivarRebajas();
    void crearEnvio();
}

class IdException extends Exception {
    public IdException(String message) {
        super(message);
    }
}

class MuchoExtracomunitarioException extends Exception {
    public MuchoExtracomunitarioException(String message) {
        super(message);
    }
}

class MangaException extends Exception {
    public MangaException(String message) {
        super(message);
    }
}

class ColoresException extends Exception {
    public ColoresException(String message) {
        super(message);
    }
}

class TallaException extends Exception {
    public TallaException(String message) {
        super(message);
    }
}

class TrajeYaExisteException extends Exception {
    public TrajeYaExisteException(String message) {
        super(message);
    }
}
