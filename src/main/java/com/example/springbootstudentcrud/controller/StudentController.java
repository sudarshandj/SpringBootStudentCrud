package com.example.springbootstudentcrud.controller;

import com.example.springbootstudentcrud.domain.Student;
import com.example.springbootstudentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    public StudentService service;

    @GetMapping("/")
    public String viewHomePage (Model model){
        List<Student> listStudent = service.listAll();
        model.addAttribute("liststudent",listStudent);
        System.out.println("Get /");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student){
        service.save(student);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id){
        ModelAndView mv = new ModelAndView("new");
        Student std = service.get(id);
        mv.addObject("student", std);
        return mv;
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent (@PathVariable(name="id") int id){
        service.delete(id);
        return "redirect:/";
    }
}
