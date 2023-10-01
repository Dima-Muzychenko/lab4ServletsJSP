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
import java.util.List;

@WebServlet("/deleteByField")
public class deleteByFieldServlet extends HttpServlet {
    private static String index = "/deleteByFieldPage.jsp";
    private static String error = "/error.jsp";
    private static String success = "/success.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sms = request.getParameter("sms");//отримуємо клас
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
//        EntityManager manager = factory.createEntityManager();
        try {
            Class cl = Class.forName("entity." + sms);
                Method columname = cl.getMethod("getTableTitlesForDelete");
                Object[] columnames = (Object[]) columname.invoke(this);
                HttpSession session = request.getSession();
                session.setAttribute("columnss",columnames);//поля таблиці
                session.setAttribute("sms",sms);//наш клас entity
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher(index).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("sms");//отримуємо таблицю
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        String value;
        String field;
        boolean isDeleted=true;
        try {
            value=request.getParameter("value");
            field=request.getParameter("field");
            manager.getTransaction().begin();
            String sql  = "DELETE FROM " + table + " e WHERE e." + field + " = '" + value + "'";
            manager.createQuery(sql).executeUpdate();
            manager.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
            isDeleted=false;
        }
        if(isDeleted) {
            request.getRequestDispatcher(success).forward(request, response);
        }
        else{
            request.getRequestDispatcher(error).forward(request, response);
        }
        factory.close();
    }
}
