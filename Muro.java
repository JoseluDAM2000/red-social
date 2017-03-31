import java.util.ArrayList;
import java.nio.file.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Desktop;

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
            File plantillaPagina = new File("recursos/pagina.html");
            BufferedWriter archivo = Files.newBufferedWriter(rutaArchivo);
            Scanner sc1 = new Scanner(plantillaPagina);
            while (sc1.hasNextLine()){
                String lineaActual = sc1.nextLine();
                if(lineaActual.contains("CONTENIDO")){
                    for(int i = entradas.size() - 1; i >= 0; i--){
                        Entrada entradaActual = entradas.get(i);
                        String[] lineasEntradaActual = entradaActual.toString().split("\n");
                        File plantillaEntrada = new File("recursos/entrada.html");
                        Scanner sc2 = new Scanner(plantillaEntrada);
                        while (sc2.hasNextLine()){
                            lineaActual = sc2.nextLine();
                            int lineasDesplazadas = 0;
                            switch(entradaActual.getClass().getSimpleName()){
                                case "EntradaFoto":
                                lineasDesplazadas = lineasEntradaActual.length - 6;
                                break;
                                case "EntradaTexto":
                                lineasDesplazadas = lineasEntradaActual.length - 5;
                            }
                            if(lineaActual.contains("Super") || lineaActual.contains(entradaActual.getClass().getSimpleName())){
                                boolean comprobar = true;
                                if(lineaActual.contains("ENTRADAUSUARIO")){
                                    lineaActual = entradaActual.getUsuario();
                                    comprobar = false;
                                }
                                if(lineaActual.contains("ENTRADATIPODEENTRADA") && comprobar){
                                    switch(entradaActual.getClass().getSimpleName()){
                                        case "EntradaUnionAGrupo":
                                        lineaActual = lineasEntradaActual[2];
                                        break;
                                        default:
                                        lineaActual = lineasEntradaActual[3 + lineasDesplazadas];
                                    }
                                    comprobar = false;
                                }
                                if(lineaActual.contains("ENTRADADATOS") && comprobar){
                                    switch(entradaActual.getClass().getSimpleName()){
                                        case "EntradaUnionAGrupo":
                                        lineaActual = lineasEntradaActual[3];
                                        break;
                                        case "EntradaFoto":
                                        lineaActual = lineasEntradaActual[5 + lineasDesplazadas];
                                        break;
                                        default:
                                        lineaActual = lineasEntradaActual[4 + lineasDesplazadas];
                                    }
                                    comprobar = false;
                                }
                                if(lineaActual.contains("ENTRADAURLIMAGEN") && comprobar){
                                    lineaActual = lineasEntradaActual[4 + lineasDesplazadas] +"\">";
                                    comprobar = false;
                                }
                                if(lineaActual.contains("ENTRADAMEGUSTA") && comprobar){
                                    lineaActual = lineasEntradaActual[1];
                                    comprobar = false;
                                }
                                if(lineaActual.contains("ENTRADAHORA") && comprobar){
                                    lineaActual = lineasEntradaActual[0].substring(entradaActual.getUsuario().length(), lineasEntradaActual[0].length());
                                    comprobar = false;
                                }
                                if(lineaActual.contains("ENTRADACOMENTARIOS") && comprobar){
                                    lineaActual = lineasEntradaActual[2] + "<br>\n";;
                                    switch(entradaActual.getClass().getSimpleName()){
                                        case "EntradaFoto":
                                        if(lineasEntradaActual.length != 6){
                                            for(int lineaComentario = 3; lineaComentario < lineasDesplazadas + 3;lineaComentario++){
                                                lineaActual += "&#8226;" + lineasEntradaActual[lineaComentario] + "<br>\n";
                                            }
                                        }
                                        break;
                                        case "EntradaTexto":
                                        if(lineasEntradaActual.length != 5){
                                            for(int lineaComentario = 3; lineaComentario < lineasDesplazadas + 3;lineaComentario++){
                                                lineaActual += "&#8226;" + lineasEntradaActual[lineaComentario] + "<br>\n";
                                            }
                                        }
                                        lineasDesplazadas = lineasEntradaActual.length - 5;
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
            File htmlFile = new File(rutaArchivo.toString());
            Desktop.getDesktop().browse(htmlFile.toURI());
        }
        catch (Exception e) {
            System.out.println("Ha sucedido un error: \n" + e.toString());
        }
        
        
    }
    
    public void mostrarMuroEnNavegador(String user)
    {
        try{
            File apiRedSocial = new File("https://script.google.com/macros/s/AKfycbzHc3p1twTfyF7o0_cxSwnxSsyOemuHnSu406ly9DZIf5Ck2BA/exec?user=" + user);
            Scanner sc = new Scanner(apiRedSocial);
            String[] entradaActual = sc.nextLine().split(";");
            entradas.clear();
            switch(entradaActual[0]){
                case "EntradaUnionAGrupo":
                EntradaUnionAGrupo entradaUnionAGrupo = new EntradaUnionAGrupo(entradaActual[1],Integer.parseInt(entradaActual[2]),entradaActual[3],entradaActual[4]);
                entradas.add(entradaUnionAGrupo);
                break;
                case "EntradaTexto":
                EntradaTexto entradaTexto = new EntradaTexto("","");
                break;
                case "EntradaFoto":
                
            }
            
            
            sc.close();
        }
        catch(Exception e){
            
        }
    }
}