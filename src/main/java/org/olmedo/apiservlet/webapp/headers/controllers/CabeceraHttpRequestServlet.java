package org.olmedo.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceras-request")
public class CabeceraHttpRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String metodoHttp = req.getMethod();
        String requestUri = req.getRequestURI(); // esta devuelve un string, esta solo devuelve lo que va despues del puerto y el localhost
        String requestUrl = req.getRequestURL().toString(); // esta devuelve un string buffer, esto devuelve todo la url completa.
        String contexPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ipCliente = req.getRemoteAddr();
        String ip = req.getLocalAddr();
        int port = req.getLocalPort();
        String scheme = req.getScheme();
        String host = req.getHeader("host");

        // creando nuestra propia url
        String url = scheme + "://" + host + contexPath + servletPath;
        String url2 = scheme + "://" + ip + ":" + port + contexPath + servletPath;

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("      <head>");
            out.println("            <meta charset=\"UTF-8\">");
            out.println("            <title>Cabeceras HTTP Request</title>");
            out.println("     </head>");
            out.println("     <body>");
            out.println("           <h1>Cabeceras HTTP Request!</h1>");
            out.println("<ul>");
            out.println("<li>metodo http: " + metodoHttp + "</li>");
            out.println("<li>request uri: " + requestUri + "</li>");
            out.println("<li>request url: " + requestUrl + "</li>");
            out.println("<li>contex path: " + contexPath + "</li>");
            out.println("<li>servlet path: " + servletPath + "</li>");
            out.println("<li>ip local: " + ip + "</li>");
            out.println("<li>ip cliente: " + ipCliente + "</li>");
            out.println("<li>port local: " + port + "</li>");
            out.println("<li>scheme: " + scheme + "</li>");
            out.println("<li>host: " + host + "</li>");
            out.println("<li>url: " + url + "</li>");
            out.println("<li>url2: " + url2 + "</li>");


            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()){
                String cabecera = headerNames.nextElement();
                out.println("<li>" + cabecera + ":" + req.getHeader(cabecera) + "</li>");
            }
            out.println("</ul>");
            out.println("      </body>");
            out.println("</html>");

        }
    }
}
