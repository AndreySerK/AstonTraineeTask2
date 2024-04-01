package org.example.servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Course;
import org.example.service.CourseService;
import org.example.service.SimpleService;
import org.example.service.impl.CourseServiceImpl;
import org.example.servlet.dto.course.CourseDto;
import org.example.servlet.dto.course.IncomingCourseDto;
import org.example.servlet.mapper.course.CourseDtoMapper;
import org.example.servlet.mapper.student.StudentListMapper;
import org.mapstruct.factory.Mappers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/")
public class CourseServlet extends HttpServlet {

    private CourseService service = new CourseServiceImpl();
    private CourseDtoMapper courseDtoMapper = Mappers.getMapper(CourseDtoMapper.class);
    private StudentListMapper studentListMapper = Mappers.getMapper(StudentListMapper.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String action = req.getServletPath();
        System.out.println(action);
        switch (action) {
            case "/course/get" -> getById(req,resp);
            case "/course/all" -> getAll(req,resp);
            case "/course/delete" -> deleteById(req,resp);
            default -> printError(resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        if (action.equals("/course/save")) {
            StringBuilder requestBody = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(req.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    requestBody.append(line);
                }
            }
            IncomingCourseDto dto = new Gson().fromJson(requestBody.toString(), IncomingCourseDto.class);
            service.save(courseDtoMapper.toEntity(dto));
            printResult("Object saved", resp);
        } else {
            printResult("Wrong url", resp);
        }
    }

    private void getById (HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));// Our Id from request
        Course byId = service.findById(id);
        CourseDto dto = courseDtoMapper.toDto(byId);
        dto.setStudents(studentListMapper.toDtoList(byId.getStudents()));
        String dtoJsonString = new Gson().toJson(dto);
        printResult(dtoJsonString,resp);
    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) {
        List<CourseDto> courses = new ArrayList<>();
        service.findAll().forEach(c -> courses.add(courseDtoMapper.toDto(c)));
        String dtoJsonString = new Gson().toJson(courses);
        printResult(dtoJsonString,resp);
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));// Our Id from request
        Boolean result = service.deleteById(id);
        printResult(result.toString(),resp);
    }

    private void printResult (String result,  HttpServletResponse resp) {
        try (PrintWriter out = resp.getWriter()) {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.print(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printError (HttpServletResponse resp) {
        try (PrintWriter out = resp.getWriter()) {
            resp.setCharacterEncoding("UTF-8");
            out.print("Wrong url");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
