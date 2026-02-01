package com.chalabookkaru.shows.service;

import com.chalabookkaru.shows.dto.CreateShowRequest;
import com.chalabookkaru.shows.dto.ShowResponse;
import com.chalabookkaru.shows.entity.Show;

import java.util.List;

public interface ShowService {

    ShowResponse createShow(CreateShowRequest createShowRequest);

    List<Show> getShowsByMovieAndCity(String title, String city);
}
