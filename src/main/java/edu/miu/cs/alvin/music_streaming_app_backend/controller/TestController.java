package edu.miu.cs.alvin.music_streaming_app_backend.controller;


import edu.miu.cs.alvin.music_streaming_app_backend.entity.Test;
import edu.miu.cs.alvin.music_streaming_app_backend.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @Autowired
    private TestRepo testRepo;

    @PostMapping("test")
    public void addData(@RequestParam String name, @RequestParam int age){
        testRepo.save(new Test(name,age));
    }

    @GetMapping("get")
    public List<Test> getData(){
        return testRepo.findAll();
    }



}
