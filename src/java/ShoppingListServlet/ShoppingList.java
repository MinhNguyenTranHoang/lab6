/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingListServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShoppingList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String name = (String) session.getAttribute("name");
        
        if (name == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        
         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action != null && action.equals("add")) {
            String item = request.getParameter("item");
            if(!item.equals("")){
                ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
            
            items.add(item);
            
            session.setAttribute("items", items);
            }else{
                request.setAttribute("message1", "HOW CAN YOU ADD NULL ITEM ???????");
            }
            
        } else if (action != null && action.equals("delete")) {
            String item = request.getParameter("item");
            if(item==null){
                request.setAttribute("message2", "PLEASE CHOOSE ITEM TO DELETE");
            }
            
            ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
            
            items.remove(item);
            
            session.setAttribute("items", items);
        } else {
            String name = request.getParameter("name");
        if(!name.equals("")){
            
           
            ArrayList<String> items = new ArrayList<>();
            session.setAttribute("name", name);
            session.setAttribute("items", items);
        }else{
            request.setAttribute("message", "Name should not be empty");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
            
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
