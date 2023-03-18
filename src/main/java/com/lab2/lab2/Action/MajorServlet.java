package com.lab2.lab2.Action;

import com.alibaba.fastjson.JSON;
import com.lab2.lab2.Dao.Impl.MajorDaoImpl;
import com.lab2.lab2.Dao.Impl.StudentDaoImpl;
import com.lab2.lab2.Dao.MajorDao;
import com.lab2.lab2.Dao.StudentDao;
import com.lab2.lab2.Entity.Major;
import com.lab2.lab2.Entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/major-servlet")
public class MajorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        MajorDao majordao = new MajorDaoImpl();
        List<Major> majorList= majordao.getAll("select * from major");
        out.print(JSON.toJSONString(majorList));
    }
}
