package com.task.three.controller;


import com.task.three.controller.command.Command;
import com.task.three.controller.command.LogoutCommand;
import com.task.three.controller.command.admin.AddNewCarCommand;
import com.task.three.controller.command.admin.AdminCarListCommand;
import com.task.three.controller.command.admin.post.AddNewCarPostCommand;
import com.task.three.controller.command.admin.post.DeleteCarCommand;
import com.task.three.controller.command.admin.post.UpdateCarCommand;
import com.task.three.controller.command.admin.post.UpdateCarSubmitCommand;
import com.task.three.controller.command.guest.LoginPageCommand;
import com.task.three.controller.command.guest.MainCommand;
import com.task.three.controller.command.guest.RegistrationPageCommand;
import com.task.three.controller.command.guest.post.LoginCommand;
import com.task.three.controller.command.guest.post.RegistrationCommand;
import com.task.three.controller.command.user.post.CreateOrderCommand;
import com.task.three.controller.command.user.OrderCarCommand;
import com.task.three.controller.command.user.post.AddOrderToCarRentalCommand;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@WebServlet("/")
public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();


    public void init(ServletConfig servletConfig){
        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());

        commands.put("logout", new LogoutCommand());
        commands.put("login", new LoginPageCommand());
        commands.put("log", new LoginCommand());
        commands.put("reg", new RegistrationCommand());
        commands.put("registration", new RegistrationPageCommand());
        commands.put("", new MainCommand());

        commands.put("admin/add_new_car", new AddNewCarCommand());
        commands.put("admin/adminCarList", new AdminCarListCommand());
        commands.put("admin/deleteCar", new DeleteCarCommand());
        commands.put("admin/updateCar", new UpdateCarCommand());
        commands.put("admin/updateCarSubmit",new UpdateCarSubmitCommand());
        commands.put("admin/addNewCarPost", new AddNewCarPostCommand());

        commands.put("user/order_car", new OrderCarCommand());
        commands.put("user/order_create", new CreateOrderCommand());
        commands.put("user/addOrderToCarRental", new AddOrderToCarRentalCommand());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        path = path.replaceAll(".*/web/" , "");
        Command command = commands.getOrDefault(path ,
                (req)->"/error.jsp");
        String page = command.execute(request);
        if (page.contains("redirect"))
            response.sendRedirect(request.getContextPath() + page.replace("redirect:", ""));
        else
            request.getRequestDispatcher(page).forward(request,response);
    }

}
