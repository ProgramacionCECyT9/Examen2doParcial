/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swing.xml;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
/**
 *
 * @author Eder Vs
 */
public class Form extends JFrame implements ActionListener
{
    JButton Enter;
    JTextField Text1;
    JTextField Text2;
    JTextField Text3;
    
    public Form()
    {
        JFrame ContainerFrame = new JFrame(); //Declara la Variable jfContenido que actuara como Frame
        ContainerFrame.setBounds(100, 20, 400, 400); //Establece las Propiedades de Dimension (BordeHorizontal,BordeVertical,TamañoHorizontal,TamañoVerical)
        ContainerFrame.setLayout(null);
        ContainerFrame.setVisible(true);
        ContainerFrame.setResizable(false);
        ContainerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container HiContainer = ContainerFrame.getContentPane();
        
        Text1 = new JTextField();
        Text1.setBounds(120, 83, 200, 25);
        HiContainer.add(Text1);
        
        Text2 = new JTextField();
        Text2.setBounds(120, 120, 200, 25);
        HiContainer.add(Text2);
        
        Text3 = new JTextField();
        Text3.setBounds(120, 160, 200, 25);
        HiContainer.add(Text3);
        
        Enter = new JButton("Cambiar datos");
        Enter.setBounds(120, 320, 150, 40);
        HiContainer.add(Enter);        
        
        Enter.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==Enter)
        {
            String String1 = Text1.getText();
            String String2 = Text2.getText();
            String String3 = Text3.getText();
            
            try 
            {
 
                Element Lala = new Element ("Texts");
                Lala.detach();
                Document doc = new Document(Lala);
 
                Element Element_Text1 = new Element("Text");
                Element_Text1.addContent(new Element("text_id").setText("1"));
                Element_Text1.addContent(new Element("text_content").setText(String1));

                doc.getRootElement().addContent(Element_Text1);

                Element Element_Text2 = new Element("Text");
                Element_Text2.addContent(new Element("text_id").setText("2"));
                Element_Text2.addContent(new Element("text_content").setText(String2));

                doc.getRootElement().addContent(Element_Text2);
                
                Element Element_Text3 = new Element("Text");
                Element_Text3.addContent(new Element("text_id").setText("3"));
                Element_Text3.addContent(new Element("text_content").setText(String3));

                doc.getRootElement().addContent(Element_Text3);

                // new XMLOutputter().output(doc, System.out);
                XMLOutputter xmlOutput = new XMLOutputter();

                // display nice nice
                xmlOutput.setFormat(Format.getPrettyFormat());
                xmlOutput.output(doc, new FileWriter("C:\\Users\\Alumno\\Desktop\\Text.xml"));

                System.out.println("File Saved!");
            } 
            catch (IOException io) 
            {
                System.out.println(io.getMessage());
            }
            
            System.out.println("Texto 1: " + String1);
            System.out.println("Texto 2: " + String2);
            System.out.println("Texto 3: " + String3);
            JOptionPane.showMessageDialog(null, "Texto 1: " + String1 + "\nTexto 2: " + String2 + "\nTexto 3: " + String3);
        }
    }
}
