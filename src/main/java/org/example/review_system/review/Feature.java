package org.example.review_system.review;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.review_system.utils.Utils;

import java.util.List;
import java.util.Random;

@Getter
@Setter
@ToString
public class Feature {
    private String productId;
    private int id;
    private String title;
    private  String text;
    private int rating;
    private String featureName;
    private List<Meta> metas;

    public Feature() {
        id = Utils.getRandomInt();
    }
}
