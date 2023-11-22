<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="public/favicon.svg" type="image/svg+xml">
    <link rel="stylesheet" href="styles/politics-and-privacity.css">
    <title>Políticas de Uso</title>
</head>
<body>
    <div class="container">
        <h1><fmt:message key="politic.privacy"/></h1>
        <br> <p><fmt:message key="politic.lastupdate"/></p> <br>
        <p><fmt:message key="politic.description"/></p>

        <h3><fmt:message key="politic.informationcollected"/></h3>

        <fmt:message key="politic.information"/><br>

<br><li><fmt:message key="politic.information1"/></li>
<li><fmt:message key="politic.information2"/></li>
<li><fmt:message key="politic.information3"/></li>
<li><fmt:message key="politic.information4"/></li>
<li><fmt:message key="politic.information5"/></li>
<li><fmt:message key="politic.information6"/></li>

<h3><fmt:message key="politic.pessoalinformation"/><br></h3>

<li><fmt:message key="politic.process"/></li>
<li><fmt:message key="politic.communication"/></li>
<li><fmt:message key="politic.anwser"/></li>
<li><fmt:message key="politic.improve"/></li>
<li><fmt:message key="politic.share"/></li><br>

<fmt:message key="politic.notshare"/>

<br><h3><fmt:message key="politic.cookies"/></h3>

<fmt:message key="politic.nave"/>

<h3><fmt:message key="politic.security"/></h3>

<fmt:message key="politic.securitymedia"/>

<h3><fmt:message key="politic.link"/></h3>

<fmt:message key="politic.linkdescription"/>

<h3><fmt:message key="politic.alteration"/></h3>

<fmt:message key="politic.alterationdescription"/>
 
<h3><fmt:message key="politic.contact"/></h3>

<fmt:message key="politic.contactdescription"/>

    </div>
</body>
</html>