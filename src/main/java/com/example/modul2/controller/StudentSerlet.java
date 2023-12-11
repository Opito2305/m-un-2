package com.example.modul2.controller;

import com.example.modul2.modul.Student;
import com.example.modul2.service.StudentServiceLmpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "Studens", value = "/students")
public class StudentSerlet extends HttpServlet {

    StudentServiceLmpl studentServiceLmpl = new  StudentServiceLmpl();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                createStudent(request, response);
                break;
            case "edit":
                EditForm(request, response);
                break;
        }

    }

    private void EditForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");;
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        double score = Double.parseDouble(request.getParameter("score"));
        studentServiceLmpl.update(id,new Student(id, name, age, sex , address,score));
        response.sendRedirect("/students");

    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");;
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        double score = Double.parseDouble(request.getParameter("score"));
        studentServiceLmpl.update(id,new Student(id, name, age, sex,address,score));
        response.sendRedirect("/students");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request, response);
                break;

            case "edit":
                showEditForm(request, response);
                break;
            case  "delete":
                delete(request,response);
                break;
            default:
                showListPage(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentServiceLmpl.delete(id);
        response.sendRedirect("/students");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Student/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Student students = studentServiceLmpl.findById(id);
        request.setAttribute("sua" , students);
        requestDispatcher.forward(request,response);

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Student/create.jsp");

        requestDispatcher.forward(request,response);
    }
    private void showListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Student/list.jsp");
        List<Student> students = studentServiceLmpl.findAll();
        request.setAttribute("danhSach" , students);
        requestDispatcher.forward(request,response);
    }
}
