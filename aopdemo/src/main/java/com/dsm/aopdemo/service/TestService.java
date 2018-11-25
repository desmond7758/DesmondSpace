package com.dsm.aopdemo.service;

import com.dsm.aopdemo.anno.Dsm;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Dsm
    public void run(String id){
        System.out.println("----跑起来吧,大兄弟----");
    }
}
