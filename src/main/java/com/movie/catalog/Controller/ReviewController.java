package com.movie.catalog.Controller;

import com.movie.catalog.Repository.ReviewRepository;
import com.movie.catalog.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository repo;

    // Option 2: Optional query param
    @GetMapping("/byBook")
    public List<Review> getReviews(@RequestParam(required = false) Long bookId) {
        if (bookId != null) {
            return repo.findByBookId(bookId);
        }
        return repo.findAll();
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return repo.save(review);
    }
}
