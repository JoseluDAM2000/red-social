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
    
    public String toString()
    {
        String valorDeRetorno = getUsuario() + " se unió al grupo: \n" + grupo + "\nHace ";
        long segundosTranscurridos = (getMomentoPublicacion().until(LocalDateTime.now(), ChronoUnit.SECONDS));
        if (segundosTranscurridos > 59) {
            long minutosTranscurridos = segundosTranscurridos/60;
            segundosTranscurridos = segundosTranscurridos%60;
            valorDeRetorno += minutosTranscurridos + " minutos ";
        }
        valorDeRetorno += segundosTranscurridos + " segundos \nTiene " + getCantidadMeGusta() + " Me gusta.";
        System.out.println(valorDeRetorno);
        return valorDeRetorno;
    }
}
