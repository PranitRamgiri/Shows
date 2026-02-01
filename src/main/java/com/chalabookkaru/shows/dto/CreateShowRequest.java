package com.chalabookkaru.shows.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public class CreateShowRequest {

    @NotBlank(message = "Please provide movie title")
    private String movieTitle;

    @NotNull(message = "Please provide show time")
    private LocalDateTime showTime;

    @NotBlank(message = "Please provide desired city")
    private String city;

    @Min(value = 50L, message = "Please provide valid total seats")
    @Max(value = 200L, message = "Please provide valid total seats")
    @NotNull(message = "Please provide total seats")
    private Long totalSeats;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Long totalSeats) {
        this.totalSeats = totalSeats;
    }
}
