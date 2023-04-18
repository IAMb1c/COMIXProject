package ImportExport;

import java.util.ArrayList;
import java.util.List;
import main.Comic;
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;  

public class XML {
    private String filename;
    private List<Comic> database;
    
    public XML(String filename){
        this.filename = filename;
        this.database = new ArrayList<>();
    }

    /**
     * 
     * @return database of comics that was creating using data from XML file
     */
    //Method not fully implemented
    public List<Comic> read(){
        try   
        {  
        //creating a constructor of file class and parsing an XML file  
        File file = new File(filename);  
        //an instance of factory that gives a document builder  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        //an instance of builder to parse the specified xml file  
        DocumentBuilder db = dbf.newDocumentBuilder();  
        Document doc = db.parse(file);  
        doc.getDocumentElement().normalize();  
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
        NodeList nodeList = doc.getElementsByTagName("row");  
        // nodeList is not iterable, so we are using for loop  
        for (int itr = 0; itr < nodeList.getLength(); itr++)   
        {  
        Node node = nodeList.item(itr);  
        if (node.getNodeType() == Node.ELEMENT_NODE)   
        {  
        Element eElement = (Element) node;  
        // System.out.println("Series: "+ eElement.getElementsByTagName("Series").item(0).getTextContent());  
        // System.out.println("variant: "+ eElement.getElementsByTagName("Description").item(0).getTextContent());  
        // System.out.println("Publisher: "+ eElement.getElementsByTagName("publisher").item(0).getTextContent());  
        // System.out.println("Release: "+ eElement.getElementsByTagName("release").item(0).getTextContent());  
        // System.out.println("Format: "+ eElement.getElementsByTagName("format").item(0).getTextContent());  

        }  
        }  
        }   
        catch (Exception e)   
        {  
        e.printStackTrace();  
        }  
        System.out.println("Reading from XML file and returning database");
        return database;
    }
}
