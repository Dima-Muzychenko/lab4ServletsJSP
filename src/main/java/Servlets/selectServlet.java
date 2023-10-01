package Servlets;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/select")
public class selectServlet extends HttpServlet {
    private static String index = "/selectpage.jsp";
//    private static String error = "/WEB-INF/error.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sms = request.getParameter("sms");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        try {
        EntityManager manager = factory.createEntityManager();
        Class cl = Class.forName("entity."+sms);
//            System.out.print("заголовки:");
//            System.out.println(sms);
            List<Object> list = manager.createQuery("FROM "+sms).getResultList();
            if(list==null){//перевірка на пустоту
                System.out.println("No result");
            }
            else {
                Method columname = cl.getMethod("getTableTitles");
                Method elements = cl.getMethod("getSelected", Object.class);
                Object[] columnames = (Object[]) columname.invoke(this);//this-cl
                Object[] row;
                List<Object[]> objectslist=new ArrayList<>();
                for (Object obj : list) {
                    row = (Object[]) elements.invoke(this, obj);
                    objectslist.add(row);
                }
                System.out.println("");

                HttpSession session = request.getSession();
                session.setAttribute("table", objectslist);
                session.setAttribute("columnss", columnames);

                System.out.print("заголовки:");
                for (Object obj : columnames) {
                    System.out.println(obj);
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher(index).forward(request,response);
        factory.close();
    }
}
