import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

/**
 * 
 */
public class EntradaTexto extends EntradaConComentario
{
    private String mensaje;

    /**
     * Constructor for objects of class EntradaTexto
     */
    public EntradaTexto(String autor, String texto)
    {
        super(autor);
        mensaje = texto;
    }
    
    /**
     * 
     */
    public String getMensaje()
    {
        return mensaje;
    }

    /**
     * 
     */
    public String toString()
    {
        String valorDeRetorno =  super.toString();
        valorDeRetorno +=  "Ha publicado un mensaje: \n" + mensaje + "\n";
        return valorDeRetorno;
    }
    
    public void mostrar()
    {
        System.out.println(this);
    }
    
    public int getCantidadDeDatosAsociadosALaEntrada()
    {
        return 5;
    }
}
