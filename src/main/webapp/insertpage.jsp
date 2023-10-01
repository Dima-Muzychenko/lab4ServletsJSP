<jsp:include page="mainpage.jsp" />

<h1>Insert</h1>
<form action="/insert" method="post">
    <table>
        <% Object[] columns=(Object[])session.getAttribute("columnss");
            for(int i=0;i<columns.length;i++){
                if(columns[i]=="number_in_order" || columns[i]=="numberOfOrder" || columns[i]=="date" || columns[i]=="number of order") continue;//поля, що заповнюються самі
                out.println("<tr><td>"+columns[i]+":</td><td><input type='text' name='"+columns[i]+"'/></td></tr>");
            }
        %>
        <% out.println("<input type='hidden' name='sms' value='"+(String)session.getAttribute("sms")+"'>"); %>
        <tr><td colspan="2"><input type="submit" value="Save"/></td></tr>
    </table>

</form>
