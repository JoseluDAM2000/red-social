import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * 
 */
public class EntradaUnionAGrupo extends Entrada
{
    private String grupo;

    /**
     * Constructor for objects of class EntradaUnionAGrupo
     */
    public EntradaUnionAGrupo(String autor, String grupo)
    {
        super(autor);
        this.grupo = grupo;
        System.out.println(autor + " se unió al grupo: " + grupo);
    }
    
    public EntradaUnionAGrupo(String autor, int cantidadMeGusta, String momentoPublicacion, String grupo)
    {
        super(autor, momentoPublicacion, cantidadMeGusta);
        this.grupo = grupo;
    }
    
    public String toString()
    {
        String valorDeRetorno = super.toString();
        valorDeRetorno += "Se unió al grupo: \n" + grupo + "\n";
        return valorDeRetorno;
    }
    
    public void mostrar()
    {
        System.out.println(this);
    }
    
    public int getCantidadDeDatosAsociadosALaEntrada()
    {
        return 4;
    }
    
    public String mostrarDatosExclusivos()
    {
        return "Grupo: " + grupo;
    }
}
