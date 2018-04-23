/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botcristian;
import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author Usuario
 */
public class BotCristian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = new File( "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\BotCristian\\urls.txt" ); 
        BufferedReader entrada; 
        try { 
            entrada = new BufferedReader( new FileReader( f ) ); 
            String linea; 
            while(entrada.ready()){ 
                linea = entrada.readLine();
                Document doc = Jsoup.connect(linea).timeout(10000).get();
                Elements urisAudio = doc.select("audio");
                for (Element var : urisAudio) {
                    System.out.println(var.attr("src"));
                }
            }
        }catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
    
}
