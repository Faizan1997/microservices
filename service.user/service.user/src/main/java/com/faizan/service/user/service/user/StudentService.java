package com.faizan.service.user.service.user;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.collections.map.HashedMap;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentService implements  IntStudentService{
    ArrayList<Student> students=new ArrayList<>();



    @Override
    public List<Student> findAll() {

        students.add(new Student(1010,"Faizan","Rawalpindi","Pakistan"));
        students.add(new Student(1011,"Ali","Islamabad","Pakistan"));
        students.add(new Student(1012,"Mujtaba","Rawalpindi","Pakistan"));
        students.add(new Student(1013,"Tashfeen","Islamabad","Pakistan"));
        students.add(new Student(1014,"Asim","Rawalpindi","Pakistan"));
        students.add(new Student(1015,"Hussain","Islamabad","Pakistan"));
        students.add(new Student(1016,"Usama","Rawalpindi","Pakistan"));
        students.add(new Student(1017,"Arslan","Islamabad","Pakistan"));

        return students;
    }

    @Override
    public String exportReport(@NotNull String format) throws FileNotFoundException, JRException {

      findAll();

        File file= ResourceUtils.getFile("classpath:Empty_Book.jrxml");
        //JasperReport jasperReport=(JasperReport) JRLoader.loadObjectFromFile(file.getAbsolutePath());
        JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource jrBeanCollectionDataSource=new JRBeanCollectionDataSource(students);
        Map<String, Object> parameters=new HashedMap();
        //parameters.put("studentParam","Faizan");
        parameters.put("studentParam",jrBeanCollectionDataSource);

        JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,parameters,new JREmptyDataSource());
        if(format.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,"F:\\SpringBoot\\8APR22\\students.pdf");
        }
        if(format.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,"F:\\SpringBoot\\8APR22\\students.html");
        }

        return "Report generated";

    }

    public Student add(Student student){
        students.add(student);
        return student;
    }

    @Override
    public Student update(Student student, Long id) {
        for(int i=0;i<students.size();i++){
            if(students.get(i).id==id){
                students.remove(i);
                students.add(student);
               return student;

            }
        }
        return null;
    }

    public void delete(Long id) {
        for(int i=0;i<students.size();i++){
            if(students.get(i).id==id){
                students.remove(i);
              return;

            }
        }

    }
}
