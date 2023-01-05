package org.example.review_system.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;

@Getter
@Setter
@AllArgsConstructor
public class Meta {
    private Long reviewId;
    private BufferedImage reviewImage;
    private String imagePath;
}
