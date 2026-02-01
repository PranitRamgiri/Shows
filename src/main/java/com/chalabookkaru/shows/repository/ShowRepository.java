package com.chalabookkaru.shows.repository;

import com.chalabookkaru.shows.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    Optional<Show> findByMovieTitle(String movieTitle);

    List<Show> findByMovieTitleAndCity(String movieTitle, String city);

    List<Show> findByCity(String city);
}
