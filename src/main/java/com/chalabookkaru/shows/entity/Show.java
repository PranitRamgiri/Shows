package com.chalabookkaru.shows.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "show")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    @Column(nullable = false, unique = true)
    private String movieTitle;

    @Column(nullable = false)
    private LocalDateTime showTime;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Long totalSeats;

    @Column(nullable = false)
    private Long availableSeats;

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public Long getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Long totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Long getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Long availableSeats) {
        this.availableSeats = availableSeats;
    }
}
