<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
    <%@page contentType="text/html;charset=UTF-8" %>
    <%@ page import="java.util.List" %>
    <%@ page import="firstwebapp.xmlmanager.MobileApp" %>
    <%@ page import="org.apache.commons.lang3.tuple.Pair" %>
    <TITLE> JavaServer Pages</TITLE>
    <META NAME="author" CONTENT="Marty Hall -- hall@apl.jhu.edu">
    <META NAME="keywords"
          CONTENT="JSP,JavaServer Pages,servlets">
    <META NAME="description"
          CONTENT="Lab 6">
    <LINK REL=STYLESHEET
          HREF="My-Style-Sheet.css"
          TYPE="text/css">
</HEAD>
<BODY BGCOLOR="#FDF5E6" TEXT="#000000" LINK="#0000EE"
      VLINK="#551A8B" ALINK="#FF0000">
<%--<%! private int accessCount = 0; %>--%>
<%--Количество обращений к странице с момента загрузки сервера:--%>
<%--<%= ++accessCount %>--%>

<%--<B>Директива (совместно с выражением).</B><BR>--%>
<%--<%@ page import = "java.util.*" %>   КОПАТЫЧ--%>
<%--Текущая дата: <%= new Date() %>--%>
<h2>Mobile apps</h2>
<ul>
    <% Pair<Integer, List<MobileApp>> result = (Pair<Integer, List<MobileApp>>) request.getAttribute("apps"); %>
    <p class="totalSize">Total Size: <%= result.getLeft() %></p>
    <ul>
        <%
            for (MobileApp item : result.getRight()) {
        %>
        <li class="listItem"><%= item.getName() %> (Size: <%= item.getSize() %>)</li>
        <%
            }
        %>
    </ul>
</ul>
</BODY>
</HTML>