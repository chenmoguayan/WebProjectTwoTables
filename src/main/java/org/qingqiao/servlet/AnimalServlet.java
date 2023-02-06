package org.qingqiao.servlet;

import com.alibaba.fastjson.JSON;
import org.qingqiao.bean.Animal;
import org.qingqiao.bean.City;
import org.qingqiao.bean.Type;
import org.qingqiao.service.AnimalServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hj
 * @data 2023/2/1 15:56
 */
@WebServlet("/animal")
public class AnimalServlet extends HttpServlet {
    AnimalServicelmpl animal = new AnimalServicelmpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String m = req.getParameter("m");
        if ("query".equals(m)){
            queryAll(req,resp);
        }else if ("insert".equals(m)){
            insert(req,resp);
        }else if ("getType".equals(m)){
            getType(req,resp);
        }else if ("queryById".equals(m)){
            queryById(req,resp);
        }else if ("update".equals(m)){
            update(req,resp);
        }else if ("delete".equals(m)){
            delete(req,resp);
        }else if ("getCity".equals(m)){
            getCity(req,resp);
        }
    }

    private void getCity(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pid = req.getParameter("id");
        List<City> list = animal.getCity(pid);
        String s = JSON.toJSONString(list);
        resp.getWriter().print(s);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int i = animal.delete(id);
        resp.getWriter().print(i > 0);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String sex = req.getParameter("sex");
        int tid = Integer.parseInt(req.getParameter("tid"));
        Type type = new Type(tid, "");
        Animal animal1 = new Animal(null,name,age,sex,type);
        int i = animal.update(id,animal1);
        resp.getWriter().print(i > 0);
    }

    private void queryById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Animal a = animal.queryById(id);
        String s = JSON.toJSONString(a);
        resp.getWriter().print(s);
    }

    private void getType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ArrayList<Type> list = animal.getType();
        String s = JSON.toJSONString(list);
        resp.getWriter().print(s);
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String sex = req.getParameter("sex");
        int tid = Integer.parseInt(req.getParameter("tid"));
        Type type = new Type(tid, "");
        Animal animal1 = new Animal(null,name,age,sex,type);
        int i = animal.insert(animal1);
        resp.getWriter().print(i > 0);
    }

    private void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Animal> list = animal.queryAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("zoo/list.jsp").forward(req, resp);
    }
}
