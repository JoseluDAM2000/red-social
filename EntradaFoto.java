import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

/**
 * 
 */
public class EntradaFoto
{
    private String usuario;
    private String urlImagen;
    private String titulo;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;
    private ArrayList<String> comentarios;

    /**
     * Constructor for objects of class EntradaFoto
     */
    public EntradaFoto(String autor, String url, String titulo)
    {
        usuario = autor;
        urlImagen = url;
        this.titulo = titulo;
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
    public void unlike()
    {
        if(cantidadMeGusta > 0){
            cantidadMeGusta--;
        }
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
    public LocalDateTime getMomentoPublicacion()
    {
        return momentoPublicacion;
    }

    /**
     * 
     */
    public String toString()
    {
        String valorDeRetorno =  usuario + " ha publicado una imagen: " + urlImagen + " " + titulo + " - Hace ";
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
