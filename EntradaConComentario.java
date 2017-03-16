import java.util.ArrayList;

/**
 * 
 */
public class EntradaConComentario extends Entrada
{
    private ArrayList<String> comentarios;

    /**
     * Constructor for objects of class EntradaConComentario
     */
    public EntradaConComentario(String autor) 
    {
        super(autor);
        comentarios = new ArrayList<String>();
    }

    /**
     * 
     */
    public void addComentario(String text)
    {
        comentarios.add(text);
    }
    
    public ArrayList<String> getComentarios()
    {
        return comentarios;
    }
    
    public String toString()
    {
        return null;
    }
}
