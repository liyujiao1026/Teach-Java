/*
read
 */
package java_xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class XMLdemo1_Read {

    public static void main(String[] args) throws Exception  {
   
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(new File("/Users/Yujiao/Desktop/java_swing/Oct22_XML_DAO/code/car.xml"));
    
    Element root = doc.getDocumentElement();
    NodeList nodeList = root.getElementsByTagName("car");

    int k = 0;
    Element car = (Element) nodeList.item(k);

            
    String regnr = car.getAttribute("regnr");
    String brand=car.getElementsByTagName("brand").item(0).getTextContent();
    String model=car.getElementsByTagName("model").item(0).getTextContent();
    String imgUrl=car.getElementsByTagName("imageurl").item(0).getTextContent();
    
    System.out.println("REGNR:" + regnr + "\nBRAND:" + brand +  "\nMODEL:" + model + "\nURL:" + imgUrl );
    }
}
    

