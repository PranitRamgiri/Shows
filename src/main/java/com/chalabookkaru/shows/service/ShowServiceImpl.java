package com.chalabookkaru.shows.service;

import com.chalabookkaru.shows.dto.CreateShowRequest;
import com.chalabookkaru.shows.dto.ShowResponse;
import com.chalabookkaru.shows.entity.Show;
import com.chalabookkaru.shows.exception.ShowException;
import com.chalabookkaru.shows.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Override
    public ShowResponse createShow(CreateShowRequest createShowRequest) {

        if (showRepository.findByMovieTitle(createShowRequest.getMovieTitle()).isPresent()) {
            throw new ShowException("Movie title already exists.", HttpStatus.CONFLICT);
        }

        Show show = new Show();
        show.setMovieTitle(createShowRequest.getMovieTitle());
        show.setShowTime(createShowRequest.getShowTime());
        show.setTotalSeats(createShowRequest.getTotalSeats());
        show.setCity(createShowRequest.getCity());
        show.setAvailableSeats(createShowRequest.getTotalSeats());
        Show savedShow = showRepository.save(show);

        ShowResponse showResponse = new ShowResponse();
        showResponse.setMovieTitle(savedShow.getMovieTitle());
        showResponse.setShowTime(savedShow.getShowTime());
        showResponse.setTotalSeats(savedShow.getTotalSeats());
        showResponse.setCity(savedShow.getCity());

        return showResponse;
    }

    @Override
    public List<Show> getShowsByMovieAndCity(String title, String city) {
        return List.of();
    }
}
