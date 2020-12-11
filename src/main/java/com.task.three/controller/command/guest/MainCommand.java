package com.task.three.controller.command.guest;


import com.task.three.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class MainCommand implements Command {


    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/guest/main.jsp";
    }
}
