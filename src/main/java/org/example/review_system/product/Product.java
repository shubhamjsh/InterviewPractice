package org.example.review_system.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.review_system.repository.ProductRepository;
import org.example.review_system.repository.ReviewRepository;
import org.example.review_system.review.Feature;
import org.example.review_system.review.Review;
import org.example.review_system.review.ReviewState;
import org.example.review_system.review.ReviewType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long productId;
    private String productName;
    private List<Review> reviews;

    public Product addProduct() {
        ProductRepository.products.add(this);
        ProductRepository.productMap.put(productId, this);
        return this;
    }

    public List<Review> getReviewsByFeature(long productId, String feature) {
        return ReviewRepository.reviews.parallelStream().filter(r -> r.getProductId().equals(productId)
        && r.getReviewState() == ReviewState.MODERATION_SUCCESS
        && getReviewsByFeature(r, feature))
                .collect(Collectors.toList());
    }

    public List<Review> getReviewsByDateDesc(long productId) {
        return ReviewRepository.reviews.parallelStream().filter(r-> r.getProductId().equals(productId)
        && r.getReviewState() == ReviewState.MODERATION_SUCCESS)
                .sorted(Comparator.comparing(Review::getReviewDate).reversed())
                .collect(Collectors.toList());
    }

    public boolean getReviewsByFeature(Review review, String feature) {
        List<Feature> features = review.getFeature();
        features = features.parallelStream().filter(r-> r.getFeatureName().contains(feature))
                .collect(Collectors.toList());
        return features.size() > 0;
    }

    public List<Review> getReviewByProduct(long productId) {
        return ReviewRepository.reviews.parallelStream().filter(r-> r.getProductId().equals(productId))
                .collect(Collectors.toList());
    }

    public List<Review> getReviewsByDate(long productId) {
        return ReviewRepository.reviews.parallelStream().filter(r-> r.getProductId().equals(productId)
        && r.getReviewState() == ReviewState.MODERATION_SUCCESS)
                .sorted(Comparator.comparing(Review::getReviewDate))
                .collect(Collectors.toList());
    }

    public List<Review> getCertifiedReviews(long productId) {
        return ReviewRepository.reviews.parallelStream().filter(r-> r.getProductId().equals(productId)
        && r.getReviewType().equals(ReviewType.CERTIFIED_BUYER))
                .collect(Collectors.toList());
    }

    public List<Review> getReviewsWithMeta(long productId) {
        return ReviewRepository.reviews.parallelStream().filter(r-> r.getProductId().equals(productId)
        && r.getReviewState() == ReviewState.MODERATION_SUCCESS
        && isMetaPresent(r))
                .collect(Collectors.toList());
    }

    public List<Review> getReviewsByRating(long productId, int star) {

        return ReviewRepository.reviews.parallelStream().filter(r-> r.getProductId().equals(productId)
        && r.getReviewState() == ReviewState.MODERATION_SUCCESS
        && r.getRating() > star)
                .collect(Collectors.toList());


    }

    public static void add(List<Review> list) {
//        return Arrays.asList();
    }


    private boolean isMetaPresent(Review review) {
        if(review.getMeta() != null && !review.getMeta().isEmpty()) {
            return true;
        }
        for(Feature feature : review.getFeature()) {
            if(feature.getMetas() != null && feature.getMetas().size() > 0) {
                return true;
            }
        }
        return false;
    }


}
