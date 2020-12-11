package com.task.three.controller.command.user.post;


import com.task.three.controller.command.Command;
import com.task.three.model.entity.CarRental;
import com.task.three.model.service.CarRentalService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

public class AddOrderToCarRentalCommand implements Command {
    CarRentalService carRentalService;

    public AddOrderToCarRentalCommand() {
        this.carRentalService = new CarRentalService();
    }

    @Override
    public String execute(HttpServletRequest request) {

        int carId = Integer.parseInt(request.getParameter("carId"));
        String name = request.getParameter("name");
        int dayAmount = Integer.parseInt(request.getParameter("dayAmount"));
        int price = Integer.parseInt(request.getParameter("price"));
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        CarRental carRental = new CarRental.Builder()
                .carId(carId)
                .clientId((Integer) request.getSession().getAttribute("userId"))
                .daysAmount(dayAmount)
                .price(price*dayAmount)
                .startDate(date)
                .build();
        carRentalService.carRental(carRental);
        request.setAttribute("carRental", carRental);
        request.setAttribute("carName", name);
        request.setAttribute("carPrice", price);
        return "/WEB-INF/user/order_submit.jsp";
    }
}
