
package xmlproba0;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class Metodos{
    
XMLOutputFactory factory =XMLOutputFactory.newInstance();
XMLStreamWriter xw; 
String ruta = "/home/oracle/NetBeansProjects/autores.xml";
public void escribir(){
    
    try {
     xw =    factory.createXMLStreamWriter(new FileWriter(ruta));
     
     xw.writeStartDocument("1.0");
     xw.writeStartElement("Autores");
     xw.writeStartElement("Autor");
     xw.writeAttribute("Codigo","a1");
     xw.writeStartElement("Nome");
     xw.writeCharacters("Alexandre Dumas");
     xw.writeEndElement();
     xw.writeStartElement("Titulo");
     xw.writeCharacters("El Conde de Montecristo");
     xw.writeEndElement();
     xw.writeStartElement("Titulo");
     xw.writeCharacters("Los Miserables");
     xw.writeEndElement();
     xw.writeEndElement();
     xw.writeStartElement("Autor");
     xw.writeAttribute("Codigo","a2");
     xw.writeStartElement("Nome");
     xw.writeCharacters("Fiodor Dostoyevski");
     xw.writeEndElement();
     xw.writeStartElement("Titulo");
     xw.writeCharacters("El Idiota");
     xw.writeEndElement();
     xw.writeStartElement("Titulo");
     xw.writeCharacters("Noches Blancas");
     xw.writeEndElement();
     xw.writeEndElement();
     xw.writeEndElement();
     
      xw.close();
    } catch (IOException | XMLStreamException ex) {
        System.out.println("Erro ao escribir "+ex.getMessage());
    }
    


}


}