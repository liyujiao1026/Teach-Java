/*
read
 */
package java_xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class XMLdemo2_Add {

    public static void main(String[] args) throws Exception  {
   
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(new File("/Users/Yujiao/Desktop/java_swing/Oct22_XML_DAO/code/car.xml"));
    
    Element root = doc.getDocumentElement();
    
  
    Element newcar = doc.createElement("car");
    newcar.setAttribute("regnr", "XYZ123");
    
    Element brand = doc.createElement("brand");
    brand.setTextContent("BMW"); 
    
    Element model = doc.createElement("model");
    model.setTextContent("m3"); 
    
    Element imgurl = doc.createElement("imageurl");
    imgurl.setTextContent("www.789.com");
    
    
    newcar.appendChild(brand);
    newcar.appendChild(model);
    newcar.appendChild(imgurl);        

    
    root.appendChild(newcar);
    writeToXML(doc);
    }
    
    private static void writeToXML (Document doc) throws Exception{
    
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
    

