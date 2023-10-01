<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Drivers</title>
</head>
<body>
<div class="mainmenu">
    <div class="dropdown">
        <button class="dropbtn">Select</button>
        <div class="dropdown-content">
            <a href="/select?sms=AutoCoursesEntity">Auto Courses</a>
            <a href="/select?sms=CertificateEntity">Certificates</a>
            <a href="/select?sms=DriverEntity">Drivers</a>
            <a href="/select?sms=ExaminationEntity">Examinations</a>
            <a href="/select?sms=MIAEntity">MIA</a>
            <a href="/select?sms=PracticeEntity">Practices</a>
            <a href="/select?sms=TestEntity">Tests</a>
        </div>
    </div>

    <div class="dropdown">
        <button class="dropbtn">Create</button>
        <div class="dropdown-content">
            <a href="/insert?sms=AutoCoursesEntity">Auto Courses</a>
            <a href="/insert?sms=CertificateEntity">Certificates</a>
            <a href="/insert?sms=DriverEntity">Drivers</a>
            <a href="/insert?sms=ExaminationEntity">Examinations</a>
            <a href="/insert?sms=MIAEntity">MIA</a>
            <a href="/insert?sms=PracticeEntity">Practices</a>
            <a href="/insert?sms=TestEntity">Tests</a>
        </div>
    </div>



    <div class="dropdown">
        <button class="dropbtn">Delete by field</button>
        <div class="dropdown-content">
            <a href="/deleteByField?sms=AutoCoursesEntity">Auto Courses</a>
            <a href="/deleteByField?sms=CertificateEntity">Certificates</a>
            <a href="/deleteByField?sms=DriverEntity">Drivers</a>
            <a href="/deleteByField?sms=ExaminationEntity">Examinations</a>
            <a href="/deleteByField?sms=MIAEntity">MIA</a>
            <a href="/deleteByField?sms=PracticeEntity">Practices</a>
            <a href="/deleteByField?sms=TestEntity">Tests</a>
        </div>
    </div>
<%--    <div class="dropdown">--%>
<%--        <button class="dropbtn">Other options</button>--%>
<%--        <div class="dropdown-content">--%>
<%--            <a href="/numberOfClientsByDay">Number of clients by day</a>--%>
<%--            <a href="/foreignClientsMonthly">Foreign clients monthly</a>--%>
<%--            <a href="/topPensioners">Top Pensioners Administrators</a>--%>
<%--            <a href="/labelRoom">Weird, profitable and popular numbers</a>--%>
<%--            <a href="/deleteByField?tbl=Rooms">Diagram</a>--%>
<%--        </div>--%>
<%--    </div>--%>
</div>

</body>
</html>
