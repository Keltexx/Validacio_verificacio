package excepciones;

public class EmptyListException extends MiExcepcion {
    public EmptyListException() {
        super("Error, elementos es lista vacía");
    }
}
