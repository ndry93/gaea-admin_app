/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hy.gaeaadmin.model.service;

import com.hy.gaeaadmin.model.dto.EmployeeDto;
import com.hy.gaeaadmin.model.entity.Employee;
import com.hy.gaeaadmin.model.repo.EmployeeRepo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ndry93
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo empRepo;
    @Autowired
    private ModelMapper modelMapper;
    
    public List<EmployeeDto> list(){
        List<EmployeeDto> empList = new ArrayList<>();
        for(Employee data : empRepo.findAll()){
            empList.add(this.convertToDto(data));
        }
        return empList;
    }
    
    public void save(EmployeeDto empDto){
        try {
            empRepo.save(this.convertToEntity(empDto));
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public EmployeeDto findById(EmployeeDto empDto){
        Optional<Employee> emp = empRepo.findById(empDto.getEmpId());
        Employee employee = emp.orElse(null);
        return employee == null ? null : this.convertToDto(employee);
    }
    
    private EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }
    
    private Employee convertToEntity(EmployeeDto employeeDto) throws ParseException {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        return employee;
    }
    
}
