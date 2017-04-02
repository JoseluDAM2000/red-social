import java.util.ArrayList;

/**
 * 
 */
public abstract class EntradaConComentario extends Entrada
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

    public EntradaConComentario(String autor, String momentoPublicacion, int cantidadMeGusta, String comentarios) 
    {
        super(autor, momentoPublicacion, cantidadMeGusta);
        this.comentarios = new ArrayList<String>();
        if(!comentarios.equals("Sin comentarios")){
            String[] comentariosDivididos = comentarios.split("%");
            for(String comentarioActual: comentariosDivididos){
                this.comentarios.add(comentarioActual);
            }
        }
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
