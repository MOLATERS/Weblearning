package com.lab2.lab2.Action;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.lab2.lab2.Dao.Impl.StudentDaoImpl;
import com.lab2.lab2.Dao.StudentDao;
import com.lab2.lab2.Entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/student-servlet")
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String action=request.getParameter("action");
        if("init".equals(action)){
            StudentDao studentdao = new StudentDaoImpl();
            List<Student> studentList= studentdao.getAll("select * from student");
            out.print(JSON.toJSONString(studentList));
        }
        else if("add".equals(action)) {
            String mid = request.getParameter("mid");
            String sname = request.getParameter("sname");
            String sid = request.getParameter("sid");
            String gender = request.getParameter("gender");
            String age = request.getParameter("age");
            String birthday = request.getParameter("birthday");
            StudentDao StudentDao = new StudentDaoImpl();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            if (StudentDao.getById(sid) == null) {
                try {
                    StudentDao.add(new Student(sid, sname, gender, Integer.parseInt(age), ft.parse(birthday), mid));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Map<String, Object> result = new HashMap<>();
                result.put("错误！","学号已存在！");
            }
        }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }
    public void destroy() {
    }
}