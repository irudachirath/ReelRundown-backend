package dev.chirath.movie_hub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, Object> payload) {
        String reviewBody = (String) payload.get("reviewBody");
        int ratings = (int) payload.get("ratings");
        String imdbId = (String) payload.get("imdbId");
        return new ResponseEntity<Review>(reviewService.createReview(reviewBody, ratings, imdbId), HttpStatus.OK);
    }
}
