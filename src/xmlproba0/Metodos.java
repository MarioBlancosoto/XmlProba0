package xmlproba0;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class Metodos {

    XMLInputFactory fic = XMLInputFactory.newInstance();
    XMLOutputFactory factory = XMLOutputFactory.newInstance();
    XMLStreamWriter xw;
    XMLStreamReader sr;
    String ruta = "/home/oracle/NetBeansProjects/autores.xml";

    public void escribir() {

        try {
            xw = factory.createXMLStreamWriter(new FileWriter(ruta));

            xw.writeStartDocument("1.0");
            xw.writeStartElement("Autores");
            xw.writeStartElement("Autor");
            xw.writeAttribute("Codigo", "a1");
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
            xw.writeAttribute("Codigo", "a2");
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
            System.out.println("Erro ao escribir " + ex.getMessage());
        }

    }

    public void ler() {
        String elemento;
        String atributo;
        try {

            sr = fic.createXMLStreamReader(new FileReader(ruta));

            while (sr.hasNext()) {
                int eventType = sr.next();
                switch (eventType) {
                    case XMLStreamReader.START_DOCUMENT:
                        break;

                    case XMLStreamReader.START_ELEMENT:
                        System.out.println(sr.getLocalName());
                        if (sr.getAttributeCount() > 0) {
                            System.out.println(sr.getAttributeName(0) + " = " + sr.getAttributeValue(0));

                        }
                        break;
                    case XMLStreamReader.CHARACTERS:
                        System.out.println(sr.getText());
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        break;
                }

            }

        } catch (XMLStreamException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
