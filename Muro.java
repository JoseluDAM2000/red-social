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

    public void mostrarDatosExclusivosEntradasFiltradas(String tipoDeEntrada, String usuario)
    {
        String valorDeRetorno = "";
        int contador = 0;
        while(contador < entradas.size()){
            Entrada entradaActual = entradas.get(contador);
            if(entradaActual.getUsuario() == usuario){
                switch(entradaActual.getClass().getSimpleName()){
                    case "EntradaUnionAGrupo":
                    EntradaUnionAGrupo entradaUnionAGrupo = (EntradaUnionAGrupo) entradaActual;
                    valorDeRetorno += entradaUnionAGrupo.mostrarDatosExclusivos() + "\n";
                    break;
    
                    case "EntradaTexto":
                    EntradaTexto entradaTexto = (EntradaTexto) entradaActual;
                    valorDeRetorno += entradaTexto.mostrarDatosExclusivos() + "\n";
                    break;
                    
                    case "EntradaFoto":
                    EntradaFoto entradaFoto = (EntradaFoto) entradaActual;
                    valorDeRetorno += entradaFoto.mostrarDatosExclusivos() + "\n";
                    break;
                    
                    default:
                }
            }
            contador++;
        }
        System.out.println(valorDeRetorno);
    }
}
