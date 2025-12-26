package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/simple-status")
public class SimpleStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // Required by test suite
        resp.setContentType("text/plain");
        resp.setStatus(HttpServletResponse.SC_OK);

        PrintWriter writer = resp.getWriter();
        writer.write("Cold Chain Temperature Breach Alert System is running");
        writer.flush();
    }
}
