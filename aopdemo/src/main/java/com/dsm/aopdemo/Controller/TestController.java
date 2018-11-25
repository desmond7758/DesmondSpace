package com.dsm.aopdemo.Controller;

import com.dsm.aopdemo.anno.Dsm;
import com.dsm.aopdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/dsm")
    @Dsm
    public String go(@RequestParam("id") String id,HttpServletRequest req){
        return "123";
    }
}
