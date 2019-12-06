package com.my.recommender.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.recommender.Recommender.Recommender;
import com.my.recommender.dao.RatingDao;
import com.my.recommender.model.Rating;
import com.my.recommender.service.RecommenderService;

@Service
public class RecommenderServiceImpl implements RecommenderService {

    @Autowired
    private RatingDao ratingDao;

    @Autowired
    private Recommender rec;

    @Override
    public double getPrediction(int userId, int filmId) {
        double prediction = -1.0;
        try {
            GenericUserBasedRecommender recommender = rec.getRecommender();
            prediction = (recommender.estimatePreference(userId, filmId));
            if (prediction != prediction) {
                prediction = -1.0;
            } // if prediction is NaN
        } catch (TasteException e) {
            e.printStackTrace();
            prediction = -1.0; // TasteException (no such user or film)
        }
        return prediction;
    }

    public File getParsedDataFile() {
        List<Rating> ratings = ratingDao.getAll();
        String path = "ratings.txt";
        FileWriter writer = null;
        try {
            writer = new FileWriter(path, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> data = new ArrayList<String>();
        String temp;
        for (Rating rating : ratings) {
            temp = Integer.toString((int) rating.getUserId()) + "," + Integer.toString((int) rating.getFilmId()) + ","
                    + Double.toString(rating.getRating());
            data.add(temp);
        }
        try {
            for (String element : data) {
                writer.write(element);
                writer.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File file = new File(path);
        return file;
    }

}