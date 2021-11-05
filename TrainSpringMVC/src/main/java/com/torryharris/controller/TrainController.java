package com.torryharris.controller;

import com.sun.istack.internal.NotNull;
import com.torryharris.DAO.TrainDAO;
import com.torryharris.api.Passenger;
import com.torryharris.api.Ticket;
import com.torryharris.api.Train;
import com.torryharris.mapper.TrainRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TrainController {
    @Autowired
    private TrainDAO trainDAO;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/showtrain")
    public ModelAndView showTrain(HttpServletRequest request, HttpServletResponse response) {
        List<Train> trainList = trainDAO.loadTrains();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("form.jsp");
        mv.addObject("trains", trainList);
        return mv;
    }

    @GetMapping("/find")
    public String bookTicket() {
        return "find.jsp";
    }

    @GetMapping("/take")
    public ModelAndView getTrain(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mv=new ModelAndView();
        int num=Integer.parseInt(request.getParameter("trainNo"));
        List<Train>trainList=trainDAO.loadTrains(num);
        mv.setViewName("book.jsp");
        mv.addObject("find",trainList);
        return mv;

    }
    @GetMapping("/addpassenger")
    public ModelAndView book(HttpServletRequest request,HttpServletResponse response)
    {
        Ticket ticket=new Ticket();
        ModelAndView mv=new ModelAndView();
        int num=Integer.parseInt(request.getParameter("trainNo"));
        int count=Integer.parseInt(request.getParameter("passNo"));
        for(int i=0;i<count;i++)
        {
            String name=request.getParameter("name"+i);
            int age=Integer.parseInt(request.getParameter("age"+i));
            char gender=request.getParameter("gender").charAt(0);
            ticket.addPassenger(name,age,gender);

        }
        String PNR=ticket.confirmTicket();
        mv.setViewName("new.jsp");
        mv.addObject("PNR",PNR);
        return mv;


    }
}
