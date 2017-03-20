import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Write a description of class Entrada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entrada
{
    private String usuario;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;
    
    /**
     * Constructor for objects of class Entrada
     */
    public Entrada(String autor)
    {
        usuario = autor;
        momentoPublicacion = LocalDateTime.now();
        cantidadMeGusta = 0;
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
    public LocalDateTime getMomentoPublicacion()
    {
        return momentoPublicacion;
    }
    
    public String getUsuario()
    {
        return usuario;
    }
    
    public int getCantidadMeGusta()
    {
        return cantidadMeGusta;
    }
    
    public String toString()
    {
        String valorDeRetorno =  getUsuario() + " hace ";
        long segundosTranscurridos = (getMomentoPublicacion().until(LocalDateTime.now(), ChronoUnit.SECONDS));
        if (segundosTranscurridos > 59) {
            long minutosTranscurridos = segundosTranscurridos/60;
            segundosTranscurridos = segundosTranscurridos%60;
            valorDeRetorno += minutosTranscurridos + " minutos ";
        }
        valorDeRetorno += segundosTranscurridos + " segundos \n" + getCantidadMeGusta() + " Me gusta. \n";
        return valorDeRetorno;
    }
    
    public void mostrar()
    {
    }
}
