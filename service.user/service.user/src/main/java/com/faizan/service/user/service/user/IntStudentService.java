package com.faizan.service.user.service.user;

import net.sf.jasperreports.engine.JRException;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.util.List;

public interface IntStudentService {
    List<Student> findAll();
    String exportReport(@NotNull String format) throws FileNotFoundException, JRException;

    Student add(Student newStudent);

    Student update(Student student, Long id);

    public void delete(Long id);
}
