/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaushalindustries.inventory;

import com.kaushalindustries.inventory.entity.Item;
//import com.kaushalindustries.inventory.entity.Worker;
import com.kaushalindustries.inventory.repository.ItemRepository;
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
public class ItemController {
    @Autowired
    ItemRepository itemRepository;
    
    @PostMapping("/addItem")
    public Item addItem(@RequestBody Item item)
    {        
        item.setActive(true);
        itemRepository.save(item);
     
        return item;
    }
    
    @PutMapping("/editItem")
    public Item editItem(@RequestBody Item item){
        Item itemdb= itemRepository.findById(item.getItemid()).orElseThrow();
        itemdb.setActive(item.getActive());
        itemdb.setType(item.getType());
        itemdb.setItemname(item.getItemname());
       
        itemRepository.save(itemdb);
        
        return itemdb;
    }
    
    @DeleteMapping("/deleteItem")
    public Map<String,Object> deleteItem(Integer itemid)
    {
        Map<String,Object> map=new HashMap<>();
        Optional<Item> item=itemRepository.findById(itemid);
        
        if(item.isPresent())
        {
            itemRepository.delete(item.get());
            map.put("status", "success");
        }
        else
        {
            map.put("status","failed");
            map.put("message","Item id not found");
        }
        
        return map;
    }
    
    @GetMapping("/getItem")
    public Map<String,Object> getItem(Integer itemid)
    {
        Map<String,Object> map=new HashMap<>();
        
        Optional<Item> item=itemRepository.findById(itemid);

        if(item.isPresent())
        {
            map.put("status","success");
            map.put("worker",item.get());
        }
        else
        {
            map.put("status","failed");
            map.put("message","item id not found");
        }
        
        return map;
    }
    
    @GetMapping("/item")
    public List<Item> getAllItems()
    {
        return itemRepository.findAll();
    }
}
