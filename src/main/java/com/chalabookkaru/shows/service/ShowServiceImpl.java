package com.chalabookkaru.shows.service;

import com.chalabookkaru.shows.client.MovieServiceClient;
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

    @Autowired
    private MovieServiceClient movieServiceClient;

    @Override
    public ShowResponse createShow(CreateShowRequest createShowRequest) {

        Long movieId = movieServiceClient.getMovieIdByTitle(createShowRequest.getMovieTitle());

        Show show = new Show();
        show.setMovieId(movieId);
        show.setMovieTitle(createShowRequest.getMovieTitle());
        show.setShowTime(createShowRequest.getShowTime());
        show.setTotalSeats(createShowRequest.getTotalSeats());
        show.setCity(createShowRequest.getCity());
        show.setTotalSeats(createShowRequest.getTotalSeats());
        show.setAvailableSeats(createShowRequest.getTotalSeats());

        Show savedShow = showRepository.save(show);

        ShowResponse showResponse = new ShowResponse();
        showResponse.setShowId(savedShow.getShowId());
        showResponse.setMovieId(savedShow.getMovieId());
        showResponse.setMovieTitle(savedShow.getMovieTitle());
        showResponse.setShowTime(savedShow.getShowTime());
        showResponse.setCity(savedShow.getCity());
        showResponse.setTotalSeats(savedShow.getTotalSeats());
        showResponse.setAvailableSeats(savedShow.getAvailableSeats());

        return showResponse;
    }

    @Override
    public List<Show> getShowsByMovieAndCity(String title, String city) {
        return List.of();
    }

    @Override
    public ShowResponse getShowById(Long showId) {
        Show showed = showRepository.findById(showId)
                .orElseThrow(() -> new ShowException("Show not exists", HttpStatus.NOT_FOUND));
        ShowResponse showResponse = new ShowResponse();
        showResponse.setShowId(showed.getShowId());
        showResponse.setMovieTitle(showed.getMovieTitle());
        showResponse.setCity(showed.getCity());
        showResponse.setShowTime(showed.getShowTime());
        showResponse.setTotalSeats(showed.getTotalSeats());
        showResponse.setAvailableSeats(showed.getAvailableSeats());
        return showResponse;
    }
}
