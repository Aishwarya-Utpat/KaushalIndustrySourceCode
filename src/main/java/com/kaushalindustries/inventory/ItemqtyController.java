/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaushalindustries.inventory;

import com.kaushalindustries.inventory.entity.Itemqty;
import com.kaushalindustries.inventory.repository.ItemqtyRepository;
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
public class ItemqtyController {
    
    @Autowired
    ItemqtyRepository itemqtyRepository;
    
    @PostMapping("/addItemqty")
    public Itemqty addItem(@RequestBody Itemqty itemqty)
    {        
       
        itemqtyRepository.save(itemqty);
     
        return itemqty;
    }
    
    @PutMapping("/editItemqty")
    public Itemqty editAttendance(@RequestBody Itemqty itemqty){
        Itemqty itemqtydb= itemqtyRepository.findById(itemqty.getItemqtyid()).orElseThrow();
        itemqtydb.setAction(itemqty.getAction());
        itemqtydb.setDate(itemqty.getDate());
        itemqtydb.setItem(itemqty.getItem());
        itemqtydb.setItemqtyid(itemqty.getItemqtyid());
        itemqtydb.setPresentqty(itemqty.getPresentqty());
        itemqtydb.setTime(itemqty.getDate());
        itemqtydb.setTotalqty(itemqty.getTotalqty());
     
        itemqtyRepository.save(itemqtydb);
        
        return itemqtydb;
    }
    
    @DeleteMapping("/deleteItemqty")
    public Map<String,Object> deleteItemqty(Integer itemqtyid)
    {
        Map<String,Object> map=new HashMap<>();
        Optional<Itemqty> itemqty=itemqtyRepository.findById(itemqtyid);
        
        if(itemqty.isPresent())
        {
            itemqtyRepository.delete(itemqty.get());
            map.put("status", "success");
        }
        else
        {
            map.put("status","failed");
            map.put("message","Item id not found");
        }
        
        return map;
    }
    
    @GetMapping("/getItemqty")
    public Map<String,Object> getItemqty(Integer itemqtyid)
    {
        Map<String,Object> map=new HashMap<>();
        
        Optional<Itemqty> itemqty=itemqtyRepository.findById(itemqtyid);

        if(itemqty.isPresent())
        {
            map.put("status","success");
            map.put("worker",itemqty.get());
        }
        else
        {
            map.put("status","failed");
            map.put("message","itemqty id not found");
        }
        
        return map;
    }
    
    @GetMapping("/itemqty")
    public List<Itemqty> getAllItems()
    {
        return itemqtyRepository.findAll();
    }
}
