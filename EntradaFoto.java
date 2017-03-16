import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

/**
 * 
 */
public class EntradaFoto extends Entrada
{
    private String urlImagen;
    private String titulo;

    /**
     * Constructor for objects of class EntradaFoto
     */
    public EntradaFoto(String autor, String url, String titulo)
    {
        super(autor);
        urlImagen = url;
        this.titulo = titulo;
    }

    /**
     * 
     */
    public String getUrlImagen()
    {
        return urlImagen;
    }

    /**
     * 
     */
    public String getTituloImagen()
    {
        return titulo;
    }

    /**
     * 
     */
    public String toString()
    {
        String valorDeRetorno =  getUsuario() + " ha publicado una imagen: " + urlImagen + " " + titulo + " - Hace ";
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
