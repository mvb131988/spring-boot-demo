package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello") 
public class HelloServlet extends HttpServlet {
    
    private GreetingService greetingService;

    @Override
    public void init() {
        // Get Spring bean from our manually loaded context
        greetingService = SpringContextLoader.getContext().getBean(GreetingService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        try (PrintWriter out = resp.getWriter()) {
            out.println(greetingService.getMessage());
        }
    }
}
