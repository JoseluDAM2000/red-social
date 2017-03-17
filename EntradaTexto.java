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
        String valorDeRetorno =  getUsuario() + " ha publicado un mensaje: \n" + mensaje + "\n" + "Hace ";
        long segundosTranscurridos = (getMomentoPublicacion().until(LocalDateTime.now(), ChronoUnit.SECONDS));
        if (segundosTranscurridos > 59) {
            long minutosTranscurridos = segundosTranscurridos/60;
            segundosTranscurridos = segundosTranscurridos%60;
            valorDeRetorno += minutosTranscurridos + " minutos ";
        }
        valorDeRetorno += segundosTranscurridos + " segundos \nTiene " + getCantidadMeGusta() + " Me gusta. \n";
        if(getComentarios().isEmpty()){
            valorDeRetorno += "Aun no hay comentarios. \n";
        }else{
            valorDeRetorno += "Comentarios: \n";
            for(String comentario : getComentarios()){
                valorDeRetorno += comentario + "\n";
            }
        }
        System.out.println(valorDeRetorno);
        return valorDeRetorno;
    }
}
