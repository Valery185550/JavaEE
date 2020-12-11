package com.task.three.controller.command.user;


import com.task.three.controller.command.Command;
import com.task.three.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class OrderCarCommand implements Command {
    CarService carService;

    public OrderCarCommand() {
        this.carService = new CarService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("items", carService.getAll());
        return "/WEB-INF/user/carList.jsp";
    }
}
