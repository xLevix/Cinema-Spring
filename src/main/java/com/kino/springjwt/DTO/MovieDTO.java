package com.kino.springjwt.DTO;

import com.kino.springjwt.entity.Movie;

public class MovieDTO {

    private Integer id;
    private String name;
    private String description;
    private Double rating;
    private Integer pegi;
    private String image;

    public MovieDTO() {
    }

    public MovieDTO(Integer id, String name, String description, Double rating, Integer pegi, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.pegi = pegi;
        this.image = image;
    }

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getName();
        this.description = movie.getDescription();
        this.rating = movie.getRating();
        this.pegi = movie.getPegi();
        this.image = movie.getImage();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getPegi() {
        return pegi;
    }

    public void setPegi(Integer pegi) {
        this.pegi = pegi;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
