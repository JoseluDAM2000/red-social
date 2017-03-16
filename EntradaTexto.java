import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

/**
 * 
 */
public class EntradaTexto extends Entrada
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
        String valorDeRetorno =  getUsuario() + " ha publicado un mensaje: " + mensaje + " - Hace ";
        long segundosTranscurridos = (getMomentoPublicacion().until(LocalDateTime.now(), ChronoUnit.SECONDS));
        if (segundosTranscurridos > 59) {
            long minutosTranscurridos = segundosTranscurridos/60;
            segundosTranscurridos = segundosTranscurridos%60;
            valorDeRetorno += minutosTranscurridos + " minutos ";
        }
        valorDeRetorno += segundosTranscurridos + " segundos con " + getCantidadMeGusta() + " Me gusta.";
        if(getComentarios().isEmpty()){
            System.out.println("Aun no hay comentarios.");
        }else{
            valorDeRetorno += " Comentarios: " + getComentarios();
        }
        return valorDeRetorno;
    }
}
