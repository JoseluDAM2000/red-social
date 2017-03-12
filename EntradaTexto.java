import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

/**
 * 
 */
public class EntradaTexto
{
    private String usuario;
    private String mensaje;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;
    private ArrayList<String> comentarios;

    /**
     * Constructor for objects of class EntradaTexto
     */
    public EntradaTexto(String autor, String texto)
    {
        usuario = autor;
        mensaje = texto;
        momentoPublicacion = LocalDateTime.now();
        cantidadMeGusta = 0;
        comentarios = new ArrayList<String>();
    }

    /**
     * 
     */
    public void meGusta()
    {
        cantidadMeGusta++;
    }

    /**
     * 
     */
    public void addComentario(String text)
    {
        comentarios.add(text);
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
    public LocalDateTime getMomentoPublicacion()
    {
        return momentoPublicacion;
    }

    /**
     * 
     */
    public String toString()
    {
        String valorDeRetorno =  usuario + " ha publicado un mensaje: " + mensaje + " - Hace ";
        long segundosTranscurridos = (momentoPublicacion.until(LocalDateTime.now(), ChronoUnit.SECONDS));
        if (segundosTranscurridos > 59) {
            long minutosTranscurridos = segundosTranscurridos/60;
            segundosTranscurridos = segundosTranscurridos%60;
            valorDeRetorno += minutosTranscurridos + " minutos ";
        }
        valorDeRetorno += segundosTranscurridos + " segundos con " + cantidadMeGusta + " Me gusta.";
        if(comentarios.isEmpty()){
            System.out.println("Aun no hay comentarios.");
        }else{
            valorDeRetorno += " Comentarios: " + comentarios;
        }
        return valorDeRetorno;
    }
}
