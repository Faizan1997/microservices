package com.faizan.service.user.service.user;

import Reports.ReportService;
import com.netflix.discovery.converters.Auto;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class FirstController {
    @Autowired
    private IntStudentService studentService;


    @GetMapping(value = "allStudent")
    public List<Student> getproducts(){
        List<Student> students=studentService.findAll();

        return students;
    }
    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
    return studentService.exportReport(format);
    }

    @PostMapping ("/addStudent")
    Student newEmployee(@RequestBody Student newStudent) {
        return studentService.add(newStudent);
    }

    @PutMapping("/updateStudent/{id}")
    Student replaceEmployee(@RequestBody Student student, @PathVariable Long id) {
        return  studentService.update(student,id);
    }
    @DeleteMapping("/deleteStudent/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
    }
    }
