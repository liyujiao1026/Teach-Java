/*
read
 */
package java_xml;

import java.io.File;
import static java.lang.System.out;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class XMLdemo4_Delete {

    public static void main(String[] args) throws Exception  {
   
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(new File("/Users/Yujiao/Desktop/java_swing/Oct22_XML_DAO/code/car.xml"));
    
    Element root = doc.getDocumentElement();
    NodeList nodeList = root.getElementsByTagName("car");
    
    int k = 0;
    Element car = (Element) nodeList.item(k);
    root.removeChild(car);
    
    //writeToXML(doc);
    
    }
    
    private static void writeToXML (Document doc) throws Exception{
    //writeToXML(doc);
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    //This instance may then be used to process XML from a variety 
    //of sources and write the transformation output to a variety of sinks.
    Transformer transformer = transformerFactory.newTransformer();
    //för "snyggare" utskrivt till xmlfil och outputfönster
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
    
    //Acts as a holder for a transformation Source tree in the form of a Document Object Model (DOM) tree.
    DOMSource source = new DOMSource(doc);
    //Acts as an holder for a transformation result, which may be XML, 
    StreamResult result = new StreamResult(new File("/Users/Yujiao/Desktop/java_swing/Oct22_XML_DAO/code/car.xml"));
    //Transform the XML Source to a Result.
    //skriver/transformerar "ner" till xml filen
    transformer.transform(source, result);

    //för att "skriva" till output fönstret för testning
    StreamResult consoleResult = new StreamResult(System.out);
    transformer.transform(source, consoleResult);
   
}
        
    
    
}
    

