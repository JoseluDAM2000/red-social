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
    public EntradaUnionAGrupo(String usuario, String grupo)
    {
        super(usuario);
        this.grupo = grupo;
        System.out.println(usuario + " se unió al grupo: " + grupo);
    }
    
    public EntradaUnionAGrupo(String usuario, int meGusta, String momentoPublicacion, String grupo)
    {
        super(usuario, momentoPublicacion, meGusta);
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
