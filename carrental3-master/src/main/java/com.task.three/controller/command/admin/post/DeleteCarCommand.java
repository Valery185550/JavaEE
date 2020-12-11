package com.task.three.controller.command.admin.post;


import com.task.three.controller.command.Command;
import com.task.three.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class DeleteCarCommand implements Command {
    CarService carService;

    public DeleteCarCommand() {
        this.carService = new CarService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        int carId = Integer.parseInt(request.getParameter("carId"));
        try {
            carService.deleteCar(carId);
        } catch (Exception e) {

        }
        return "redirect:/admin/adminCarList";
    }
}
