/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hy.gaeaadmin.view.controller;

import com.hy.gaeaadmin.model.dto.EmployeeDto;
import com.hy.gaeaadmin.model.service.EmployeeService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ndry93
 */
@Controller
public class EmployeeController {
    private static final String VIEW_EMPLOYEE_V = "employee/viewEmployee";
    private static final String LIST_EMPLOYEE_V = "employee/listEmployee";

    @Autowired
    private EmployeeService empService;

    @GetMapping("/employee")
    public String employee(Map<String, Object> model) {
        model.put("employees", empService.list());

        return LIST_EMPLOYEE_V;
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        EmployeeDto empDto = new EmployeeDto();
        model.addAttribute("employeeDto", empDto);
        model.addAttribute("editMode", true);
        return VIEW_EMPLOYEE_V;
    }
    
    @GetMapping("/viewEmployee")
    public String viewEmployee(Model model, @RequestParam("id") int empId) {
        EmployeeDto tempDto = new EmployeeDto();
        tempDto.setEmpId(empId);
        EmployeeDto empDto = empService.findById(tempDto);
        model.addAttribute("employeeDto", empDto);
        model.addAttribute("editMode", false);
        return VIEW_EMPLOYEE_V;
    }
    
    @PostMapping("/addEmployee")
    public String saveEmployee(Model model, //
            @ModelAttribute("employeeDto") EmployeeDto employeeDto) {
        String firstName = employeeDto.getFirstName();
        String lastName = employeeDto.getLastName();
 
        if (firstName != null && firstName.length() > 0 //
                && lastName != null && lastName.length() > 0) {
            empService.save(employeeDto);
 
            return "redirect:/employee";
        }
 
        model.addAttribute("errorMessage", "First Name & Last Name required");
        model.addAttribute("editMode", true);
        
        return VIEW_EMPLOYEE_V;
    }

}
