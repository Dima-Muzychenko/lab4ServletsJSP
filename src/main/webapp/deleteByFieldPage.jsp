<jsp:include page="mainpage.jsp" />

<h1>Delete</h1>
<form action="/deleteByField" method="post">
    <select name="field">
        <% Object[] columns=(Object[])session.getAttribute("columnss");
            for(int i=0;i<columns.length;i++){
                out.println("<option>"+columns[i]+"</option>");
            }
        %>
    </select>
    <input type="text" name="value"/>
    <% out.println("<input type='hidden' name='sms' value='"+(String)session.getAttribute("sms")+"'>"); %>
    <tr><td colspan="2"><input type="submit" value="Delete"/></td></tr>
</form>