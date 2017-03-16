import java.util.ArrayList;

/**
 * 
 */
public class Muro
{
    private ArrayList<EntradaTexto> mensajes;
    private ArrayList<EntradaFoto> fotos;
    private ArrayList<EntradaUnionAGrupo> unionesAGrupos;

    /**
     * Constructor for objects of class Muro
     */
    public Muro()
    {
        mensajes = new ArrayList<EntradaTexto>();
        fotos = new ArrayList<EntradaFoto>();
        unionesAGrupos = new ArrayList<EntradaUnionAGrupo>();
    }

    /**
     * 
     */
    public void addEntradaTexto(EntradaTexto entradaTexto)
    {
        mensajes.add(entradaTexto);
    }

    /**
     * 
     */
    public void addEntradaFoto(EntradaFoto entradaFoto)
    {
        fotos.add(entradaFoto);
    }
    
    /**
     * 
     */
    public void addEntradaUnionAGrupo(EntradaUnionAGrupo entradaUnionAGrupo)
    {
        unionesAGrupos.add(entradaUnionAGrupo);
    }

    /**
     * 
     */
    public String toString()
    {
        return mensajes.toString() + "\n" + fotos.toString() + "\n" + unionesAGrupos.toString();
    }
}
