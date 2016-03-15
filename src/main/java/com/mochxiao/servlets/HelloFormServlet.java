package com.mochxiao.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Moch on 3/15/16.
 */

public class HelloFormServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        System.out.println("-----Headers start-----");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            System.out.println(name + ": " + request.getHeader(name));
        }

        System.out.println("-----Headers end-----");

        System.out.println("-----Parameter start-----");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name + ": " + request.getParameter(name));
        }

        System.out.println("-----Parameter end-----");

        Enumeration<String> names = request.getAttributeNames();
        while (names.hasMoreElements()) {
            String attribue = names.nextElement();
            System.out.println("Attribute: " + request.getAttribute(attribue));
        }


        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        if (null != firstName ) {
            Cookie firstNameCookie = new Cookie("first_name", firstName);
            firstNameCookie.setMaxAge(60*60*24);
            response.addCookie(firstNameCookie);
        }
        if (null != lastName) {
            Cookie lastNameCookie = new Cookie("last_name", lastName);
            lastNameCookie.setMaxAge(60*60*24);
            response.addCookie(lastNameCookie);
        }

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Using GET Method to Read Form Data/Setting Cookies Example";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.write(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>First Name</b>: "
                + request.getParameter("first_name") + "\n" +
                "  <li><b>Last Name</b>: "
                + request.getParameter("last_name") + "\n" +
                "</ul>\n" +
                "</body></html>");

    }

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}