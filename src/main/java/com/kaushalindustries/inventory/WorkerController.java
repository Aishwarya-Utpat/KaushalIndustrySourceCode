/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaushalindustries.inventory;

import com.kaushalindustries.inventory.entity.Worker;
import com.kaushalindustries.inventory.repository.WorkerRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aishwarya Utpat
 */
@RestController
public class WorkerController {
    
    @Autowired
    WorkerRepository workerRepository;
    
//    @GetMapping("/hello")
//    public String hello(@RequestParam(name="query", required = false) String name)
//    {
//        if(name==null) name="XYZ";
//        return "hello "+name;
//    }
        
    @PostMapping("/addworker")
    public Worker addWorker(@RequestBody Worker worker)
    {        
        worker.setActive(true);
        workerRepository.save(worker);
        
        return worker;
    }
    
    @PutMapping("/editworker")
    public Worker editWorker(@RequestBody Worker worker)
    {
        Worker workerdb=workerRepository.findById(worker.getId()).orElseThrow();
        workerdb.setActive(worker.getActive());
        workerdb.setAddress(worker.getAddress());
        workerdb.setName(worker.getName());
        workerdb.setPhone(worker.getPhone());
        
        workerRepository.save(workerdb);
        
        return workerdb;
    }
    
    @DeleteMapping("/deleteworker")
    public Map<String,Object> deleteWorker(Integer workerid)
    {
        Map<String,Object> map=new HashMap<>();
        Optional<Worker> worker=workerRepository.findById(workerid);
        
        if(worker.isPresent())
        {
            workerRepository.delete(worker.get());
            map.put("status", "success");
        }
        else
        {
            map.put("status","failed");
            map.put("message","Worker id not found");
        }
        
        return map;
    }
    
    @GetMapping("/getworker")
    public Map<String,Object> getWorker(Integer workerid)
    {
        Map<String,Object> map=new HashMap<>();
        
        Optional<Worker> worker=workerRepository.findById(workerid);

        if(worker.isPresent())
        {
            map.put("status","success");
            map.put("worker",worker.get());
        }
        else
        {
            map.put("status","failed");
            map.put("message","Worker id not found");
        }
        
        return map;
    }
    
    @GetMapping("/workers")
    public List<Worker> getAllWorkers()
    {
        return workerRepository.findAll();
    }
}
