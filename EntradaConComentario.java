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
        String valorDeRetorno = super.toString();
        if(comentarios.isEmpty()){
            valorDeRetorno += "Aun no hay comentarios. \n";
        }else{
            valorDeRetorno += "Comentarios: \n";
            for(String comentario : comentarios){
                valorDeRetorno += comentario + "\n";
            }
        }
        return valorDeRetorno;
    }
}
