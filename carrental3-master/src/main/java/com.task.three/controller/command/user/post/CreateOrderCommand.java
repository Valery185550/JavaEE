package com.task.three.controller.command.user.post;

import com.task.three.controller.command.Command;
import com.task.three.model.service.CarRentalService;
import com.task.three.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class CreateOrderCommand implements Command {
    CarRentalService carRentalService;
    CarService carService;

    public CreateOrderCommand() {
        this.carRentalService = new  CarRentalService();
        this.carService = new CarService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        int carId = Integer.parseInt(request.getParameter("carId"));
        try {
            request.setAttribute("car", carService.getCar(carId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/user/create_order.jsp";
    }
}
