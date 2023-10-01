<jsp:include page="mainpage.jsp" />
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<h1>Update</h1>
<form action="/update" method="post">
    <table>
        <% Object[] columns=(Object[])session.getAttribute("columns");//колонки без id
            Object[] values=(Object[])session.getAttribute("values");//значення без id
            for(int i=0;i<columns.length;i++){
//                if(columns[i]=="count_days") continue;
                out.println("<tr><td>"+columns[i]+":</td><td><input type='text' name='"+columns[i]+"' value='"+values[i]+"'/></td></tr>");
            }
        %>
    </table>
    <% out.println("<input type='hidden' name='sms' value='"+(String)request.getParameter("sms")+"'>"); %>
    <% out.println("<input type='hidden' name='id' value='"+(String)request.getParameter("id")+"'>"); %>
    <tr><td colspan="2"><input type="submit" value="Update"/></td></tr>
</form>
