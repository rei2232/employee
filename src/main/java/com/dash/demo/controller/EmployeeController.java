package com.dash.demo.controller;

import com.dash.demo.exception.ResourceNotFoundException;
import com.dash.demo.model.Employee;
import com.dash.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // get all employee aka list of employee
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // create new employee my guy rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        // save() method creates new entity to the database
        return employeeRepository.save(employee);
    }
    // get employee by id rest api
    // PathVariable gets {eid} from @GetMapping then converts into java variable eid
    @GetMapping("/employees/{eid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer eid) {
        // If object match exact id doesn't exits then throw error (orElseThrow() )
        Employee employee = employeeRepository.findById(eid).orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + eid));
        return ResponseEntity.ok(employee);
    }
    // RequestBody converts JSON object to java object
    @PutMapping("/employees/{eid}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer eid, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(eid).orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + eid));
        employee.setEid(employeeDetails.getEid());
        employee.setEname(employeeDetails.getEname());
        employee.setEaddress(employeeDetails.getEaddress());
        employee.setEsalary(employeeDetails.getEsalary());
        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

}
