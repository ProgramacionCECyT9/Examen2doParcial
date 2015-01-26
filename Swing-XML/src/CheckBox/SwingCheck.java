/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CheckBox;

/**
 *
 * @author eder
 */
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SwingCheck extends JFrame
{
    JCheckBox gender_checkbox;
    JComboBox gender_combobox;
    
    public SwingCheck()
    {
        JFrame ContainerFrame = new JFrame(); //Declara la Variable jfContenido que actuara como Frame
        ContainerFrame.setBounds(100, 20, 400, 400); //Establece las Propiedades de Dimension (BordeHorizontal,BordeVertical,TamañoHorizontal,TamañoVerical)
        ContainerFrame.setLayout(null);
        ContainerFrame.setVisible(true);
        ContainerFrame.setResizable(false);
        ContainerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container HiContainer = ContainerFrame.getContentPane();
        
        gender_combobox = new JComboBox();
        gender_combobox.setBounds(120, 240, 200, 25);
        
        try 
        {
            
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new URL("http://localhost:8080/Servlet/Hola").openStream());
            System.out.println("Holaaaaaaa");
            document.getDocumentElement().normalize();
            System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());
            NodeList Texts = document.getElementsByTagName("Text");
            System.out.println("Textos:");

            for (int s = 0; s < Texts.getLength(); s++) {

                Node Text = Texts.item(s);

                if (Text.getNodeType() == Node.ELEMENT_NODE) {

                    Element fstElmnt = (Element) Text;
                    NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("text_id");
                    Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
                    NodeList fstNm = fstNmElmnt.getChildNodes();
                    System.out.println("Text id: "  + ((Node) fstNm.item(0)).getNodeValue());
                    
                    NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("text_name");
                    Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
                    NodeList lstNm = lstNmElmnt.getChildNodes();
                    System.out.println("Gender content: " + ((Node) lstNm.item(0)).getNodeValue());
                    gender_combobox.addItem(((Node) lstNm.item(0)).getNodeValue());
                }

            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        HiContainer.add(gender_combobox);
    }
}
