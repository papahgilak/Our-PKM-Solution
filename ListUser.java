/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
/**
 *
 * @author USER
 */
public class ListUser {
    public List <User> user;
    
    public ListUser(){
        this.user = new ArrayList();
    }
    
    public void saveDataToXML(ListUser _larikUser) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        doc.setXmlStandalone(true);
        Element rootElement = doc.createElement("user");
        doc.appendChild(rootElement);
        
        for(int i = 0; i < _larikUser.user.size(); i++){
            Element element_user = doc.createElement("User");
            element_user.setAttribute("Type", ""+_larikUser.user.get(i).getType());
            rootElement.appendChild(element_user);
            Element fieldUsername = doc.createElement("Username");
            fieldUsername.setTextContent(_larikUser.user.get(i).getUsername());
            element_user.appendChild(fieldUsername);
            Element fieldPassword = doc.createElement("Password");
            fieldPassword.setTextContent(_larikUser.user.get(i).getPassword());
            element_user.appendChild(fieldPassword);
        }
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource dom = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("user.xml"));
        transformer.transform(dom, result);
    }
    
    public void openXMLtoList(ListUser _larikUser) throws Exception{
        String Username, Password, Type, RootElement, RowElement;
        
        File fileXML = new File("user.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fileXML);
        doc.getDocumentElement().normalize();
        
        RootElement = doc.getDocumentElement().getNodeName();
        NodeList nList = doc.getElementsByTagName("User");
        
        for(int i = 0; i < nList.getLength(); i++){
            Node nNode = nList.item(i);
            RowElement = nNode.getNodeName();
            if(nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;
                Type = eElement.getAttribute("Type");
                Username = eElement.getElementsByTagName("Username").item(0).getTextContent();
                Password = eElement.getElementsByTagName("Password").item(0).getTextContent();
                User A = new User(Username, Password, Type);
                _larikUser.user.add(A);
            }
        }
    }
    
    public void nambahElemen(ListUser _larikUser, User _User){
        _larikUser.user.add(_User);
    }
    
    public int cariElemen(String _Username, String _Password, ListUser _larikUser){
        boolean ketemu = false;
        int j=0;
        
        while(j<=_larikUser.user.size()-1 & !ketemu){
            if(_larikUser.user.get(j).getUsername().equals(_Username)&&_larikUser.user.get(j).getPassword().equals(_Password)){
                ketemu = true;
            }else{
                j = j+1;
            }
        }
        return j;
    }
    
    public int cariElemen1(String _Username, ListUser _larikUser){
        boolean ketemu = false;
        int j=0;
        
        while(j<=_larikUser.user.size()-1 & !ketemu){
            if(_larikUser.user.get(j).getUsername().equals(_Username)){
                ketemu = true;
            }else{
                j = j+1;
            }
        }
        return j;
    }

}
