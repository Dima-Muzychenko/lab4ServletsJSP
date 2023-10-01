package Servlets;

import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/update")
public class updateServlet extends HttpServlet {
    private static String index = "/updatepage.jsp";
    private static String success = "/success.jsp";
    private static String error = "/error.jsp";



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sms = request.getParameter("sms");//отримуємо клас
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        try {
            Class cl = Class.forName("entity." + sms);
            List<Object> list = manager.createQuery("FROM " + sms).getResultList();
            if (list == null) {//перевірка на пустоту
                System.out.println("No result");
            } else {
                Method columname = cl.getMethod("getTableTitles");//потрібні поля таблиць (без id)
                Object[] columnames = (Object[]) columname.invoke(this);//this-cl

                Object[] columnameswithoutid = new Object[columnames.length-1];
                for (int i = 0; i < columnames.length-1; i++) {//залишаємо всі заголовки крім id
                        columnameswithoutid[i]=columnames[i+1];
                        System.out.println(columnameswithoutid[i]);
                }
                Object en;//для знаходження потрібного об'єкта
                if(sms.equals("AutoCoursesEntity") || sms.equals("DriverEntity") ||  sms.equals("ExaminationEntity") || sms.equals("MIAEntity")){
                    en = manager.find(cl, String.valueOf(request.getParameter("id")));//за класом та ключем знаходимо об'єкт БД. якщо id у нас строкове, то так
                    System.out.println("The ID is String: "+String.valueOf(request.getParameter("id")));
                }
                else{
                    en = manager.find(cl, Integer.valueOf(request.getParameter("id")));//за класом та ключем знаходимо об'єкт БД
                    System.out.println("The ID is Int: "+Integer.valueOf(request.getParameter("id")));
                }

                Method s=cl.getMethod("getSelectPublicInfo",Object.class);//отримуємо поля для зміни (без id)
                Object[] columnValues = (Object[]) s.invoke(null,en);//список полів для нашого об'єкта


                Enumeration<String> enu =request.getSession().getAttributeNames();
                while (enu.hasMoreElements()){
                    System.out.println("всі змінні на початку: "+enu.nextElement());
                }

                HttpSession session = request.getSession();
                session.setAttribute("columns", columnameswithoutid);//колонки без id
                session.setAttribute("values",columnValues);//поля без id

//                Enumeration<String> enume =request.getSession().getAttributeNames();
//                System.out.println("всі змінні в середині:");
//                while (enume.hasMoreElements()){
//                    System.out.println("змінна: "+enume.nextElement()+ " значення " + session.getAttribute(enume.nextElement()));
//                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher(index).forward(request,response);//передаємо дані updatapage.jsp
        factory.close();
    }

    @Override//отримуємо змінені дані від updatapage.jsp
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//внесення змін в БД
        String table = request.getParameter("sms");//отримуємо таблицю
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        List<Object> data= new ArrayList<>();
        boolean isInserted=true;
        try{
        switch (table){
            case "AutoCoursesEntity":
                System.out.println(data.add(request.getParameter("id")));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_A1"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_A"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_B1"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_B"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_C1"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_C"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_D1"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_D"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_C1E"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_BE"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_CE"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_D1E"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_DE"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_T1"))));
                System.out.println(data.add(Boolean.parseBoolean(request.getParameter("Category_T2"))));
                System.out.println(data.add(request.getParameter("courses_name")));
                System.out.println(data.add(request.getParameter("address")));
                System.out.println(data.add(request.getParameter("teacher_full_name")));

                AutoCoursesEntity course = manager.find(AutoCoursesEntity.class, request.getParameter("id"));
//                course.setInstitutionCode((String) data.get(0));//id змінювати нельзя в Hibernate
                course.setCategoryA1((Boolean) data.get(1));
                course.setCategoryA((Boolean) data.get(2));
                course.setCategoryB1((Boolean) data.get(3));
                course.setCategoryB((Boolean) data.get(4));
                course.setCategoryC1((Boolean) data.get(5));
                course.setCategoryC((Boolean) data.get(6));
                course.setCategoryD1((Boolean) data.get(7));
                course.setCategoryD((Boolean) data.get(8));
                course.setCategoryC1E((Boolean) data.get(9));
                course.setCategoryBe((Boolean) data.get(10));
                course.setCategoryCe((Boolean) data.get(11));
                course.setCategoryD1E((Boolean) data.get(12));
                course.setCategoryDe((Boolean) data.get(13));
                course.setCategoryT1((Boolean) data.get(14));
                course.setCategoryT2((Boolean) data.get(15));
                course.setCoursesName((String) data.get(16));
                course.setAddress((String) data.get(17));
                course.setTeacherFullName((String) data.get(18));
                manager.getTransaction().begin();
                manager.merge(course);//оновляємо дані
                manager.getTransaction().commit();
                break;

            case "CertificateEntity":
                data.add(request.getParameter("id"));
                data.add(Boolean.parseBoolean(request.getParameter("Category_A1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_A")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_B1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_B")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_C1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_C")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_D1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_D")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_C1E")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_BE")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_CE")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_D1E")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_DE")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_T1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_T2")));
                data.add(request.getParameter("pasport_id"));
                data.add(request.getParameter("institution_id"));


                CertificateEntity certificate = manager.find(CertificateEntity.class, Integer.valueOf(request.getParameter("id")));
                DriverEntity driver = manager.find(DriverEntity.class, data.get(16));
                certificate.setDriverByPasportId(driver);
                certificate.setCategoryA1((Boolean) data.get(1));
                certificate.setCategoryA((Boolean) data.get(2));
                certificate.setCategoryB1((Boolean) data.get(3));
                certificate.setCategoryB((Boolean) data.get(4));
                certificate.setCategoryC1((Boolean) data.get(5));
                certificate.setCategoryC((Boolean) data.get(6));
                certificate.setCategoryD1((Boolean) data.get(7));
                certificate.setCategoryD((Boolean) data.get(8));
                certificate.setCategoryC1E((Boolean) data.get(9));
                certificate.setCategoryBe((Boolean) data.get(10));
                certificate.setCategoryCe((Boolean) data.get(11));
                certificate.setCategoryD1E((Boolean) data.get(12));
                certificate.setCategoryDe((Boolean) data.get(13));
                certificate.setCategoryT1((Boolean) data.get(14));
                certificate.setCategoryT2((Boolean) data.get(15));
                AutoCoursesEntity cours = manager.find(AutoCoursesEntity.class, data.get(17));
                certificate.setAutoCoursesByInstitutionId(cours);
                manager.getTransaction().begin();
                manager.merge(certificate);//оновляємо дані
                manager.getTransaction().commit();
                break;
            case "DriverEntity":
                data.add(request.getParameter("id"));
                data.add(Boolean.parseBoolean(request.getParameter("Category_A1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_A")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_B1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_B")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_C1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_C")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_D1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_D")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_C1E")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_BE")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_CE")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_D1E")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_DE")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_T1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_T2")));
                data.add(request.getParameter("fullName"));
                data.add(request.getParameter("birthday_date"));


//                System.out.println(request.getParameter("id"));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_A1")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_A")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_B1")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_B")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_C1")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_C")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_D1")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_D")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_C1E")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_BE")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_CE")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_D1E")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_DE")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_T1")));
//                System.out.println(Boolean.parseBoolean(request.getParameter("Category_T2")));
//                System.out.println(request.getParameter("fullName"));
//                System.out.println(request.getParameter("birthday_date"));

                DriverEntity driverr = manager.find(DriverEntity.class, request.getParameter("id"));
                driverr.setCategoryA1((Boolean) data.get(1));
                driverr.setCategoryA((Boolean) data.get(2));
                driverr.setCategoryB1((Boolean) data.get(3));
                driverr.setCategoryB((Boolean) data.get(4));
                driverr.setCategoryC1((Boolean) data.get(5));
                driverr.setCategoryC((Boolean) data.get(6));
                driverr.setCategoryD1((Boolean) data.get(7));
                driverr.setCategoryD((Boolean) data.get(8));
                driverr.setCategoryC1E((Boolean) data.get(9));
                driverr.setCategoryBe((Boolean) data.get(10));
                driverr.setCategoryCe((Boolean) data.get(11));
                driverr.setCategoryD1E((Boolean) data.get(12));
                driverr.setCategoryDe((Boolean) data.get(13));
                driverr.setCategoryT1((Boolean) data.get(14));
                driverr.setCategoryT2((Boolean) data.get(15));

                System.out.println("seconds");
                System.out.println(data.get(0));
                System.out.println((Boolean) data.get(1));
                System.out.println((Boolean) data.get(2));
                System.out.println((Boolean) data.get(3));
                System.out.println((Boolean) data.get(4));
                System.out.println((Boolean) data.get(5));
                System.out.println((Boolean) data.get(6));
                System.out.println((Boolean) data.get(7));
                System.out.println((Boolean) data.get(8));
                System.out.println((Boolean) data.get(9));
                System.out.println((Boolean) data.get(10));
                System.out.println((Boolean) data.get(11));
                System.out.println((Boolean) data.get(12));
                System.out.println((Boolean) data.get(13));
                System.out.println((Boolean) data.get(14));
                System.out.println((Boolean) data.get(15));

                driverr.setFullName((String) data.get(16));//помилка
                System.out.println((String) data.get(16));

                Date dob = null;
                try {
                    dob = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(data.get(17)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
//                driverr.setBirthdayDate(dob);
                System.out.println((String) data.get(17));
                manager.getTransaction().begin();
                manager.merge(driverr);
                manager.getTransaction().commit();
                break;
            case "ExaminationEntity":
                data.add(request.getParameter("id"));
                data.add(Boolean.parseBoolean(request.getParameter("Category_A1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_A")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_B1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_B")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_C1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_C")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_D1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_D")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_C1E")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_BE")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_CE")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_D1E")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_DE")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_T1")));
                data.add(Boolean.parseBoolean(request.getParameter("Category_T2")));
                data.add(request.getParameter("passed_category"));
                data.add(request.getParameter("pasport_id"));
                data.add(request.getParameter("MIA id"));

                ExaminationEntity exam = manager.find(ExaminationEntity.class, request.getParameter("id"));
                DriverEntity driverrr = manager.find(DriverEntity.class, data.get(17));
                exam.setDriverByPasportId(driverrr);
                MIAEntity mia = manager.find(MIAEntity.class, data.get(18));
                exam.setMiaByMinistryOfInternalAffairsId(mia);
                exam.setCategoryA1((Boolean) data.get(1));
                exam.setCategoryA((Boolean) data.get(2));
                exam.setCategoryB1((Boolean) data.get(3));
                exam.setCategoryB((Boolean) data.get(4));
                exam.setCategoryC1((Boolean) data.get(5));
                exam.setCategoryC((Boolean) data.get(6));
                exam.setCategoryD1((Boolean) data.get(7));
                exam.setCategoryD((Boolean) data.get(8));
                exam.setCategoryC1E((Boolean) data.get(9));
                exam.setCategoryBe((Boolean) data.get(10));
                exam.setCategoryCe((Boolean) data.get(11));
                exam.setCategoryD1E((Boolean) data.get(12));
                exam.setCategoryDe((Boolean) data.get(13));
                exam.setCategoryT1((Boolean) data.get(14));
                exam.setCategoryT2((Boolean) data.get(15));
                exam.setPassedCategory((String) data.get(16));

                manager.getTransaction().begin();
                manager.merge(exam);//оновляємо дані
                manager.getTransaction().commit();
                break;

            case "MIAEntity":
                data.add(request.getParameter("id"));
                data.add(request.getParameter("address"));

                MIAEntity Mia = manager.find(MIAEntity.class, request.getParameter("id"));//знаходимо потрібний курс по institutionCode
                Mia.setAddress((String) data.get(1));
                manager.getTransaction().begin();
                manager.merge(Mia);//оновляємо дані
                manager.getTransaction().commit();
                break;

            case "PracticeEntity":
                data.add(Integer.parseInt(request.getParameter("id")));
                data.add(request.getParameter("examinationByExaminationId"));
                data.add(Boolean.parseBoolean(request.getParameter("passedUnpassed")));
                data.add(Integer.parseInt(request.getParameter("leftAttempts")));
                data.add(Integer.parseInt(request.getParameter("usedAttempts")));
                data.add(request.getParameter("date"));

                PracticeEntity practice = manager.find(PracticeEntity.class, Integer.valueOf(request.getParameter("id")));
                ExaminationEntity examm = manager.find(ExaminationEntity.class, data.get(1));
                practice.setExaminationByExaminationId(examm);
                practice.setPassedUnpassed((Boolean) data.get(2));
                practice.setLeftAttempts((Integer) data.get(3));
                practice.setUsedAttempts((Integer) data.get(4));
                practice.setDate();
                manager.getTransaction().begin();
                manager.merge(practice);//оновляємо дані
                manager.getTransaction().commit();
                break;
                
            case "TestEntity":
                data.add(Integer.parseInt(request.getParameter("id")));
                data.add(request.getParameter("Examination id"));
                data.add(Boolean.parseBoolean(request.getParameter("Passed")));
                data.add(Integer.parseInt(request.getParameter("Used attempts")));
                data.add(request.getParameter("date"));

                TestEntity test = manager.find(TestEntity.class, Integer.valueOf(request.getParameter("id")));
                ExaminationEntity exammm = manager.find(ExaminationEntity.class, data.get(1));
                test.setExaminationByExaminationId(exammm);
                test.setPassedUnpassed((Boolean) data.get(2));
                test.setUsedAttempts((Integer) data.get(3));
                test.setDate();
                manager.getTransaction().begin();
                manager.merge(test);//оновляємо дані
                manager.getTransaction().commit();
                break;
        }
        }
        catch(Exception e){
            e.printStackTrace();
            isInserted=false;
        }
        Enumeration<String> en =request.getSession().getAttributeNames();
        while (en.hasMoreElements()){
            System.out.println("всі змінні в кінці: "+en.nextElement());
        }
        factory.close();
        if(isInserted) {
            request.getRequestDispatcher(success).forward(request, response);
        }
        else{
            request.getRequestDispatcher(error).forward(request, response);
        }
    }
}
