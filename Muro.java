import java.util.ArrayList;
import java.nio.file.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

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
            if(entradaActual.getUsuario() == usuario || usuario == null){
                String valorActual = "";

                switch(entradaActual.getClass().getSimpleName()){
                    case "EntradaUnionAGrupo":
                    EntradaUnionAGrupo entradaUnionAGrupo = (EntradaUnionAGrupo) entradaActual;
                    valorActual = entradaUnionAGrupo.mostrarDatosExclusivos() + "\n";
                    break;

                    case "EntradaTexto":
                    EntradaTexto entradaTexto = (EntradaTexto) entradaActual;
                    valorActual = entradaTexto.mostrarDatosExclusivos() + "\n";
                    break;

                    case "EntradaFoto":
                    EntradaFoto entradaFoto = (EntradaFoto) entradaActual;
                    valorActual = entradaFoto.mostrarDatosExclusivos() + "\n";
                    break;

                    default:
                }

                if(entradaActual.getClass().getSimpleName() == tipoDeEntrada || tipoDeEntrada == null){
                    valorDeRetorno += valorActual;
                }

            }
            contador++;
        }
        System.out.println(valorDeRetorno);
    }

    public void mostrarMuroEnNavegador()
    {
        Path rutaArchivo = Paths.get("muro.html");

        try  
        {
            File lectura1 = new File("recursos/pagina.html");
            BufferedWriter archivo = Files.newBufferedWriter(rutaArchivo);
            Scanner sc1 = new Scanner(lectura1);
            while (sc1.hasNextLine()){
                String lineaActual = sc1.nextLine();

                if(lineaActual.contains("CONTENIDO")){

                    for(int i = entradas.size() - 1; i >= 0; i--){
                        String[] entradaActual = entradas.get(i).toString().split("\n");
                        String[] primeraLinea = entradaActual[0].split(" ");
                        File lectura2 = new File("recursos/entrada.html");
                        Scanner sc2 = new Scanner(lectura2);

                        while (sc2.hasNextLine()){
                            lineaActual = sc2.nextLine();
                            int lineasDesplazadas = 0;
                            
                            if(!entradas.get(i).getClass().getSimpleName().equals("EntradaUnionAGrupo")){
                                EntradaConComentario entradaAux = (EntradaConComentario) entradas.get(i);
                                lineasDesplazadas = entradaAux.getComentarios().size();
                            }

                            if(lineaActual.contains("Super") || lineaActual.contains(entradas.get(i).getClass().getSimpleName())){
                                boolean comprobar = true;
                                if(lineaActual.contains("ENTRADAUSUARIO")){
                                    lineaActual = primeraLinea[0];
                                    comprobar = false;
                                }

                                if(lineaActual.contains("ENTRADATIPODEENTRADA") && comprobar){
                                    if(entradas.get(i).getClass().getSimpleName().equals("EntradaUnionAGrupo")){
                                        lineaActual = entradaActual[2];
                                    }else{
                                        lineaActual = entradaActual[3 + lineasDesplazadas];
                                    }
                                    comprobar = false;
                                }

                                if(lineaActual.contains("ENTRADADATOS") && comprobar){
                                    if(entradas.get(i).getClass().getSimpleName().equals("EntradaUnionAGrupo")){
                                        lineaActual = entradaActual[3];
                                    }else if(entradas.get(i).getClass().getSimpleName().equals("EntradaFoto")){
                                        lineaActual = entradaActual[5 + lineasDesplazadas];
                                    }else{
                                        lineaActual = entradaActual[4 + lineasDesplazadas];
                                    }
                                    comprobar = false;
                                }

                                if(lineaActual.contains("ENTRADAURLIMAGEN") && comprobar){
                                    lineaActual = entradaActual[4 + lineasDesplazadas] +"\">";
                                    comprobar = false;
                                }

                                if(lineaActual.contains("ENTRADAMEGUSTA") && comprobar){
                                    lineaActual = entradaActual[1];
                                    comprobar = false;
                                }

                                if(lineaActual.contains("ENTRADAHORA") && comprobar){
                                    lineaActual = entradaActual[0].substring(entradas.get(i).getUsuario().length(), entradaActual[0].length());
                                    comprobar = false;
                                }

                                if(lineaActual.contains("ENTRADACOMENTARIOS") && comprobar){
                                    EntradaConComentario entradaAux = (EntradaConComentario) entradas.get(i);
                                    if(entradaAux.getComentarios().size() != 0){
                                        lineaActual = "";
                                        for(String comentario:entradaAux.getComentarios()){
                                            lineaActual += "&#8226;" + comentario + "<br>\n";
                                        }
                                    }else{
                                        lineaActual = entradaActual[2];
                                    }
                                    comprobar = false;
                                }

                                archivo.write(lineaActual);
                            }
                        }

                        sc2.close();
                        lineaActual = "";

                    }

                }

                archivo.write(lineaActual);
            }
            sc1.close();
            archivo.close();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}


