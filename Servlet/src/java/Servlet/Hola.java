/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "Hola", urlPatterns = {"/Hola"})
public class Hola extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try 
        {
            File file = new File("C:\\Users\\Alumno\\Desktop\\Text.xml");
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder DB = DBF.newDocumentBuilder();
            Document document = DB.parse(file);
            document.getDocumentElement().normalize();
            out.println("<" + document.getDocumentElement().getNodeName() + ">");
            NodeList Texts = document.getElementsByTagName("Text");
            System.out.println("Textos:");
 
            for (int s = 0; s < Texts.getLength(); s++) {
                
                Node Text = Texts.item(s);
                out.println("<Text>");
                if (Text.getNodeType() == Node.ELEMENT_NODE) {

                    Element fstElmnt = (Element) Text;
                    NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("text_id");
                    Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
                    NodeList fstNm = fstNmElmnt.getChildNodes();
                    System.out.println("Text id: "  + ((Node) fstNm.item(0)).getNodeValue());
                    out.println("<text_id>");
                    out.println(((Node) fstNm.item(0)).getNodeValue());
                    out.println("</text_id>");
                    
                    NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("text_content");
                    Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
                    NodeList lstNm = lstNmElmnt.getChildNodes();
                    System.out.println("Gender content: " + ((Node) lstNm.item(0)).getNodeValue());
                    out.println("<text_name>");
                    out.println(((Node) lstNm.item(0)).getNodeValue());
                    out.println("</text_name>");
                    
                }
                out.println("</Text>");

            }
            out.println("</" + document.getDocumentElement().getNodeName() + ">");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
