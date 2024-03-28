package org.example.servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Course;
import org.example.service.CourseService;
import org.example.service.impl.CourseServiceImpl;
import org.example.servlet.dto.CourseDto;
import org.example.servlet.dto.IncomingDto;
import org.example.servlet.dto.OutGoingDto;
import org.example.servlet.mapper.CourseDtoMapper;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@WebServlet(urlPatterns = "/")
public class CourseServlet extends HttpServlet {

    private CourseService service = new CourseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String action = req.getServletPath();
        System.out.println(action);
        switch (action) {
            case "/course/get" -> getById(req,resp);
            case "/course/all" -> getAll(req,resp);
            case "/course/insert" -> getById(req,resp);
            case "/course/delete" -> getById(req,resp);
            default -> printError(resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Course simple = dtoMapper.toEntity(new CourseDto());
//        Course saved = service.save(simple);
//        CourseDto map = dtoMapper.toDto(saved);
        // return our DTO, not necessary
    }

    private void getById (HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));// Our Id from request
        Course byId = service.findById(id);
        CourseDto dto = Mappers.getMapper(CourseDtoMapper.class).toDto(byId);
        String dtoJsonString = new Gson().toJson(dto);
        printResult(dtoJsonString,resp);
    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) {
        List<CourseDto> courses = new ArrayList<>();
        service.findAll().forEach(c -> courses.add(Mappers.getMapper(CourseDtoMapper.class).toDto(c)));
        String dtoJsonString = new Gson().toJson(courses);
        printResult(dtoJsonString,resp);
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
