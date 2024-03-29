/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaushalindustries.inventory;

import com.kaushalindustries.inventory.entity.Attendance;
import com.kaushalindustries.inventory.repository.AttendanceRepository;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aishwarya Utpat
 */
@RestController
public class AttendanceController {
    
    @Autowired
    AttendanceRepository attendanceRepository;
    
    @PostMapping("/addAttendance")
    public Attendance addAttendance(@RequestBody Attendance attendance){
        //attendance.setAction("In");
        attendance.setDate(new Date());
        attendance.setTime(new Date());
        attendanceRepository.save(attendance);
        
        return attendance;
    }
    
    @PutMapping("/editAttendance")
    public Attendance editAttendance(@RequestBody Attendance attendance){
        Attendance attendancedb= attendanceRepository.findById(attendance.getAttendanceId()).orElseThrow();
        attendancedb.setAction(attendance.getAction());
        //attendancedb.setAttendanceId(attendance.getAttendanceId());
        attendancedb.setDate(attendance.getDate());
        attendancedb.setTime(attendance.getDate());
        //attendancedb.setWorkerId(attendance.getWorkerId());
        
        attendanceRepository.save(attendancedb);
        
        return attendancedb;
    }
    
    @DeleteMapping("/deleteAttendance")
    public Map<String,Object> deleteAttendance(Integer attendanceId)
    {
        Map<String,Object> map=new HashMap<>();
        Optional<Attendance> attendance=attendanceRepository.findById(attendanceId);
        
        if(attendance.isPresent())
        {
            attendanceRepository.delete(attendance.get());
            map.put("status", "success");
        }
        else
        {
            map.put("status","failed");
            map.put("message","Attendance id not found");
        }
        
        return map;
    }
    
    @GetMapping("/getAttendance")
    public Map<String,Object> getAttendance(Integer attendanceId){
        Map<String,Object> map=new HashMap<>();
        
        Optional<Attendance> attendance=attendanceRepository.findById(attendanceId);
        
        if(attendance.isPresent()){
            map.put("Status", "Sucess");
            map.put("Attendance", attendance.get());
        }
        else{
            map.put("Status", "Failed");
            map.put("Attendance","Attendance Id is not present");
        }
        return map;
    }
    
    @GetMapping("/Attendance")
    public List<Attendance> getAllAttendance()
    {
        return attendanceRepository.findAll();
    }
}
