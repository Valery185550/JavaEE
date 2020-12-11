package com.task.three.controller.command.admin;

import com.task.three.controller.command.Command;
import com.task.three.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class AdminCarListCommand  implements Command {
    CarService carService;


    public AdminCarListCommand() {
        this.carService = new CarService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("items", carService.getAll());

        return "/WEB-INF/admin/adminCarList.jsp";
    }
}
