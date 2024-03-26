package com.company.springmvc.cortoller;

import com.company.springmvc.entity.Book;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 处理POJO对象
 * 如果请求参数是一个POJO,springMVC会自动为这个pojo对象赋值
 * 1. 将pojo的每一个属性,从request参数中尝试获取出来,并封装即可
 * 2. 还可以级联封装
 * 3. 请求参数的参数名和对象 的属性名一一对应
 */
@Controller
public class FifthController {

    @RequestMapping("bookHandler")
    public String addBook(Book book){
        System.out.println("The book I wanted to save is  "+book);
        return "success";
    }

    /**
     * springMVC可以直接c参数上写原生API
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * java.security.Principal
     * Local: gu哦计划有关的区域信息对象
     * InputStream
     * OutputStream
     * Reader
     * Writer
     * ServletInputStream inputStream = request.getInputStream();
     * ServletOutputStream outputStream = response.getOutputStream();
     * BufferedReader reader = request.getReader();
     * PrintWriter writer = response.getWriter();
     */
    @RequestMapping("/httpHandler")
    public String handler(HttpSession httpSession,
                          HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        request.setAttribute("reqParam", "我是请求域中的");
        httpSession.setAttribute("sessionParam","I am in the session area.");


        return "httpHandler";
    }
    /**
     * 提交的数据有乱码:
     * 请求乱码:
     *      GET请求: 改server.xml, 在8080端口处, URIEncoding,="utf-8"
     *      POST请求:
     *                  - 在第一次请求之前设置
     *                      requset.setCharacterEncoding("UTF-8")
     *                  - 配置springMVC的filter
     * 响应乱码:
     *      同上,在web.xml中配置springMVC的filter
     * 不过,配置没起作用为什么?
     */
}
