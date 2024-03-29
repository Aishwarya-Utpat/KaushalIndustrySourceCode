/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kaushalindustries.inventory.repository;

import com.kaushalindustries.inventory.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aishwarya Utpat
 */

@Repository
public interface ItemRepository extends JpaRepository <Item,Integer> {
    
}
    