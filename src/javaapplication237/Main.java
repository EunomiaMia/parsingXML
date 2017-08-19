
package javaapplication237;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException, XPathExpressionException{
        XMLInputFactory inputFactory = XMLInputFactory.newFactory();
        Reader reader = new FileReader("catalog.xml");
        
        XMLStreamReader xmlsr = inputFactory.createXMLStreamReader(reader);
        
        while(xmlsr.hasNext()){
        
            switch(xmlsr.next()){
                case XMLStreamReader.START_ELEMENT:
                    
                    String elementName = xmlsr.getName().toString();
                    
                    switch(elementName){
                        case "book":
                            for (int i = 0; i < xmlsr.getAttributeCount(); i++) {
                                String attributeName = xmlsr.getAttributeLocalName(i);
                                String attributeValue = xmlsr.getAttributeValue(i);
                                
                                System.out.println(attributeName + " = " + attributeValue);
                            }
                        break;
                            
                        case "author":
                            System.out.println("Author: " + xmlsr.getElementText());
                            break;
                            
                        case "title:":
                            System.out.println("Title: " + xmlsr.getElementText());
                            break;
                            
                        case "genere":
                            System.out.println("Genere: " +xmlsr.getElementText());
                            break;
                            
                        case "price":
                            System.out.println("Price: " +xmlsr.getElementText());
                            break;
                            
                        case "publish_date":
                            System.out.println("Publish_date: " + xmlsr.getElementText());
                            break;
                            
                        case "description":
                            System.out.println("Description: " + xmlsr.getElementText() + "\n");
                            break;
                    }
                    
                    
                    break;
            
                    
                    
            }
        }
        
        
        //za detaljniji prikaz
        XPathFactory factory = XPathFactory.newInstance();
        XPath path = factory.newXPath();
        XPathExpression xPathExpression = path.compile("//book[price>10 and translate(publish_date, '-', '')> 20051231]/title");
        
        
        File xmlDocoument = new File("catalog.xml");
        InputSource inputSource = new InputSource(new FileInputStream(xmlDocoument));
        
        Object result = xPathExpression.evaluate(inputSource, XPathConstants.NODESET);
       
        
        NodeList nodeList = (NodeList)result;
        
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.print("Node name: "+nodeList.item(i).getNodeName());
            System.out.print(" Node value: "+nodeList.item(i).getFirstChild().getNodeValue());
            System.out.print("\n");
        }
    }
}
