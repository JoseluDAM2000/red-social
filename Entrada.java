import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

/**
 * Write a description of class Entrada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entrada
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

    public Entrada(String autor, String momentoPublicacion, int cantidadMeGusta)
    {
        usuario = autor;
        String[] fechaHora = momentoPublicacion.split("-");
        String[] fecha = fechaHora[0].split("/");
        String[] hora = fechaHora[1].split(":");
        this.momentoPublicacion = LocalDateTime.of(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]), Integer.parseInt(hora[0]), Integer.parseInt(hora[1]));
        this.cantidadMeGusta = cantidadMeGusta;
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

    public abstract void mostrar();

    public abstract int getCantidadDeDatosAsociadosALaEntrada();
}
