package Servlets;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
    private static String index = "/deleteByFieldPage.jsp";
    private static String error = "/error.jsp";
    private static String success = "/success.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String table = request.getParameter("sms");
        int idd = Integer.parseInt(request.getParameter("id"));



        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        try {
            Class entityClass = Class.forName("entity." + table);
            Object en;
            if(table.equals("AutoCoursesEntity") || table.equals("DriverEntity") ||  table.equals("ExaminationEntity") || table.equals("MIAEntity")){
                en = manager.find(entityClass, String.valueOf(request.getParameter("id")));//за класом та ключем знаходимо об'єкт БД. якщо id у нас строкове, то так
            }
            else{
                en = manager.find(entityClass, Integer.valueOf(request.getParameter("id")));//за класом та ключем знаходимо об'єкт БД
            }
            manager.getTransaction().begin();
            manager.remove(en);
            manager.getTransaction().commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher(success).forward(request, response);
        factory.close();
    }
}
