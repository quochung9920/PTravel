/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptravel.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author quoch
 */
@Entity
@Table(name = "tour_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TourOrder.findAll", query = "SELECT t FROM TourOrder t"),
    @NamedQuery(name = "TourOrder.findById", query = "SELECT t FROM TourOrder t WHERE t.id = :id"),
    @NamedQuery(name = "TourOrder.findByDepartureDay", query = "SELECT t FROM TourOrder t WHERE t.departureDay = :departureDay"),
    @NamedQuery(name = "TourOrder.findByNumberAdult", query = "SELECT t FROM TourOrder t WHERE t.numberAdult = :numberAdult"),
    @NamedQuery(name = "TourOrder.findByNumberChildren", query = "SELECT t FROM TourOrder t WHERE t.numberChildren = :numberChildren"),
    @NamedQuery(name = "TourOrder.findByTotalPrice", query = "SELECT t FROM TourOrder t WHERE t.totalPrice = :totalPrice")})
public class TourOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "departure_day")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDay;
    @Column(name = "number_adult")
    private Integer numberAdult;
    @Column(name = "number_children")
    private Integer numberChildren;
    @Column(name = "total_price")
    private Integer totalPrice;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "tour_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private TourDetail tourId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User userId;

    public TourOrder() {
    }

    public TourOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(Date departureDay) {
        this.departureDay = departureDay;
    }

    public Integer getNumberAdult() {
        return numberAdult;
    }

    public void setNumberAdult(Integer numberAdult) {
        this.numberAdult = numberAdult;
    }

    public Integer getNumberChildren() {
        return numberChildren;
    }

    public void setNumberChildren(Integer numberChildren) {
        this.numberChildren = numberChildren;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public TourDetail getTourId() {
        return tourId;
    }

    public void setTourId(TourDetail tourId) {
        this.tourId = tourId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourOrder)) {
            return false;
        }
        TourOrder other = (TourOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ptravel.pojos.TourOrder[ id=" + id + " ]";
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
}
