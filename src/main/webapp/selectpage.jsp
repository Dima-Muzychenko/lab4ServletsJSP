<jsp:include page="mainpage.jsp" />  <!--відображаємо головну сторінку, щоб не переключатися постійно між сторінками -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>

<style type="text/css">
    table {
        border-collapse: collapse; /* Отображать двойные линии как одинарные */
    }
    th {
        background: #ccc; /* Цвет фона */
        text-align: left; /* Выравнивание по левому краю */
    }
    td, th {
        border: 1px solid #800; /* Параметры границы */
        padding: 4px; /* Поля в ячейках */
    }
</style>
<table>
    <% Object[] columns= (Object[]) session.getAttribute("columnss");
        out.println("<tr>");
        for(Object column:columns){
            out.println("<th >"+column+"</th>");
        }
        out.println("<th>Operations</th>");
        out.println("</tr>");
    %>
    <%
        List<Object[]> tbl = (List<Object[]>) session.getAttribute("table");
        for(Object[] row:tbl){
            out.println("<tr>");
            for(Object col:row){
                out.println("<td>");
                out.println(col);
                out.println("</td>");
            }
            out.println("<td>");
            out.println("<a  class='updateBtn' href='/update?sms="+request.getParameter("sms")+"&id="+row[0]+"'>Update</a>");
            out.println("<a  class='deleteBtn' href='/delete?sms="+request.getParameter("sms")+"&id="+row[0]+"'>Delete</a>");
            //row[0] - id. Наприклад для водія це PasportId
            out.println("</td>");
            out.println("</tr>");
        }
    %>

</table>
