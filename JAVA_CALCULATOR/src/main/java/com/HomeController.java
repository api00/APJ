package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    private DataSource dataSource;

    public HomeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<h1>Hello Java<h1>");
    }

    @RequestMapping("/greet")
    public String greet() {
        return "home";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("name", "Mir Md Kawsur");
        return "welcome";
    }

    @RequestMapping("/register-form")
    public String registrationForm() {
        return "registration";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Registration Page: " + request.getParameter("username"));
        return "registration";
    }

    @RequestMapping("/register/v2")
    public String registerTwo(@ModelAttribute("firstname") String firstname, @ModelAttribute("lastname") String lastname, Model model) {
        model.addAttribute("firstname", firstname);
        model.addAttribute("lastname", lastname);
        return "welcome";
    }

    @RequestMapping("/data")
    public void getData() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from operations");
           while(resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getInt(3));

        }


    }

    @RequestMapping("/data/create")
    public String createData(@ModelAttribute("input1") int input1, @ModelAttribute("input2") int input2, Model model) throws SQLException {
        Connection connection = dataSource.getConnection();
        String data = input1+" "+input2;
        int res = input1+input2;

        PreparedStatement statement = connection.prepareStatement("insert into operations (operation, results) values (?, ?)");
        statement.setString(1, data);
        statement.setInt(2, res);
        statement.execute();

        model.addAttribute("res",res );
        return "registration";
    }
    @RequestMapping("/data/update")
    public void createUpdate(@ModelAttribute("input1") int input1, @ModelAttribute("input2") int input2, Model model) throws SQLException {
        Connection connection = dataSource.getConnection();
        String data = input1+" "+input2;
        int res = input1+input2;
        PreparedStatement statement = connection.prepareStatement("update operations set operation = ?, results = ? where id = ?");
        statement.setString(1, data);
        statement.setInt(2, res);
        statement.setLong(3, 2);
        statement.executeUpdate();
    }
}
