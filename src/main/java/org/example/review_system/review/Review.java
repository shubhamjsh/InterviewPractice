package org.example.review_system.review;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.review_system.utils.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class Review {
    private Long id;
    private Long productId;
    private int rating;
    private String title;
    private String text;
    private String userId;
    private LocalDateTime reviewDate;
    private String location;

    private List<Meta> meta;
    private List<Feature> feature;
    private ReviewState reviewState;
    private ReviewType reviewType;

    public Review() {
        id = Utils.getRandomLong();
    }


}
