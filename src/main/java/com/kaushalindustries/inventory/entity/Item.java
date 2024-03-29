/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaushalindustries.inventory.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Aishwarya Utpat
 */
@Entity
@Table(name = "item")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemid")
    private Integer itemid;
    @Column(name = "type")
    private String type;
    @Column(name = "itemname")
    private String itemname;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @OneToMany(mappedBy = "item")
    private List<Itemqty> itemqtyList;

    public Item() {
    }

    public Item(Integer itemid) {
        this.itemid = itemid;
    }

    public Item(Integer itemid, boolean active) {
        this.itemid = itemid;
        this.active = active;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemId) {
        this.itemid = itemId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Itemqty> getItemqtyList() {
        return itemqtyList;
    }

    public void setItemqtyList(List<Itemqty> itemqtyList) {
        this.itemqtyList = itemqtyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemid != null ? itemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemid == null && other.itemid != null) || (this.itemid != null && !this.itemid.equals(other.itemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kaushalindustries.inventory.entity.Item[ itemId=" + itemid + " ]";
    }
    
}
