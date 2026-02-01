package com.chalabookkaru.shows.dto;

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

    @NotNull(message = "Please provide total seats")
    private int totalSeats;

    public String getMovieTitle() {
        return movieTitle;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public String getCity() {
        return city;
    }

    public int getTotalSeats() {
        return totalSeats;
    }
}
