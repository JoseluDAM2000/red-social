import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

/**
 * 
 */
public class EntradaFoto extends EntradaConComentario
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
        String valorDeRetorno =  super.toString();
        valorDeRetorno += "Ha publicado una imagen: \n" + urlImagen + "\n" + titulo + "\n";
        return valorDeRetorno;
    }
    
    public void mostrar()
    {
        System.out.println(this);
    }
    
    public int getCantidadDeDatosAsociadosALaEntrada()
    {
        return 6;
    }
    
    public String mostrarDatosExclusivos()
    {
        return "URL de la imagen: " + urlImagen + "\n Titulo: " + titulo;
    }
}
