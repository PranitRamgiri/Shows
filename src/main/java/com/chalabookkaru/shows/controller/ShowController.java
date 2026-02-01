package com.chalabookkaru.shows.controller;

import com.chalabookkaru.shows.dto.CreateShowRequest;
import com.chalabookkaru.shows.dto.ShowResponse;
import com.chalabookkaru.shows.service.ShowService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/create")
    public ResponseEntity<ShowResponse> createShow(@Valid @RequestBody CreateShowRequest createShowRequest) {
        ShowResponse showResponse = showService.createShow(createShowRequest);
        return new ResponseEntity<>(showResponse, HttpStatus.CREATED);
    }
}
