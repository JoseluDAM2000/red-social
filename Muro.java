import java.util.ArrayList;

/**
 * 
 */
public class Muro
{
    private ArrayList<Entrada> entradas;

    /**
     * Constructor for objects of class Muro
     */
    public Muro()
    {
        entradas = new ArrayList<Entrada>();
    }

    /**
     * 
     */
    public void addEntrada(Entrada entrada)
    {
        entradas.add(entrada);
    }

    /**
     * 
     */
    public String toString()
    {
        String valorDeRetorno = "";
        for(Entrada entrada : entradas){
            valorDeRetorno += entrada + "\n";
        }
        return valorDeRetorno;
    }
    
    public void mostrar()
    {
        System.out.println(this);
    }
    
    public void verCantidadDeDatosPorEntrada()
    {
        String valorDeRetorno = "";
        for(Entrada entrada : entradas){
            valorDeRetorno += entrada.getCantidadDeDatosAsociadosALaEntrada() + "\n";
        }
        System.out.println(valorDeRetorno);
    }
}
