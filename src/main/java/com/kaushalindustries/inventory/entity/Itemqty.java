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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Aishwarya Utpat
 */
@Entity
@Table(name = "itemqty")
@NamedQueries({
    @NamedQuery(name = "Itemqty.findAll", query = "SELECT i FROM Itemqty i")})
public class Itemqty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemqtyid")
    private Integer itemqtyid;
    @Column(name = "totalqty")
    private String totalqty;
    @Column(name = "presentqty")
    private String presentqty;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "Time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Column(name = "action")
    private String action;
    @JoinColumn(name = "item", referencedColumnName = "itemid")
    @ManyToOne
    private Item item;

    public Itemqty() {
    }

    public Itemqty(Integer itemqtyid) {
        this.itemqtyid = itemqtyid;
    }

    public Integer getItemqtyid() {
        return itemqtyid;
    }

    public void setItemqtyid(Integer itemqtyid) {
        this.itemqtyid = itemqtyid;
    }

    public String getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(String totalqty) {
        this.totalqty = totalqty;
    }

    public String getPresentqty() {
        return presentqty;
    }

    public void setPresentqty(String presentqty) {
        this.presentqty = presentqty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemqtyid != null ? itemqtyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemqty)) {
            return false;
        }
        Itemqty other = (Itemqty) object;
        if ((this.itemqtyid == null && other.itemqtyid != null) || (this.itemqtyid != null && !this.itemqtyid.equals(other.itemqtyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kaushalindustries.inventory.entity.Itemqty[ itemQtyId=" + itemqtyid + " ]";
    }
    
}
