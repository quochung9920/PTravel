package com.ptravel.pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author quoch
 */
@Entity
@Table(name = "tour_detail")
public class TourDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tour_name")
    private String tourName;

    @NotNull
    @Type(type = "text")
    @Column(name = "header")
    private String header;

    
    @Type(type = "text")
    @Column(name = "intro")
    private String intro;

    
    @Type(type = "text")
    @Column(name = "schedule")
    private String schedule;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourId")
    @JsonIgnore
    private List<TourOrder> tourOrderList;

    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Region regionId;

    @JoinColumn(name = "season_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Season seasonId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourId")
    @JsonIgnore
    private List<Comment> commentList;

    @NotNull
    @Column(name = "price_adult")
    private Integer priceAdult;

    @Column(name = "price_child")
    private Integer priceChild;

    @Column(name = "image")
    private String image;

    @Transient
    private MultipartFile[] imageTour;


    public TourDetail() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public List<TourOrder> getTourOrderList() {
        return tourOrderList;
    }

    public void setTourOrderList(List<TourOrder> tourOrderList) {
        this.tourOrderList = tourOrderList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Integer getPriceAdult() {
        return priceAdult;
    }

    public void setPriceAdult(Integer priceAdult) {
        this.priceAdult = priceAdult;
    }

    public Integer getPriceChild() {
        return priceChild;
    }

    public void setPriceChild(Integer priceChild) {
        this.priceChild = priceChild;
    }

    public Region getRegionId() {
        return regionId;
    }

    public void setRegionId(Region regionId) {
        this.regionId = regionId;
    }

    public Season getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Season seasonId) {
        this.seasonId = seasonId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile[] getImageTour() {
        return imageTour;
    }

    public void setImageTour(MultipartFile[] imageTour) {
        this.imageTour = imageTour;
    }

    
    
}
