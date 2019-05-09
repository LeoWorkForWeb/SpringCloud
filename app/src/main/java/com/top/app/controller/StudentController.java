package com.top.app.controller;

import com.top.app.core.controller.TopController;
import com.top.app.core.result.Result;
import com.top.app.core.result.ResultGenerator;
import com.top.app.model.Student;
import com.top.app.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.MapKey;
import java.text.ParseException;

@RestController
@RequestMapping("/com/top/app/controller")
public class StudentController extends TopController {

    @Resource
    private StudentService studentService;

    @PostMapping(value = "insert")
    public Result insert(@RequestBody Student student){

        logger.info(student.toString());
        try {
            studentService.insert(student);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping(value = "delete")
    public Result delete(String id){


        return ResultGenerator.genSuccessResult();
    }

    @PostMapping(value = "update")
    public Result update(String id){


        return ResultGenerator.genSuccessResult();
    }

    @PostMapping(value = "query")
    public Result query(String id){


        return ResultGenerator.genSuccessResult();
    }




}





