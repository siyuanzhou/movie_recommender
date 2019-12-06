package com.my.recommender.Recommender;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.my.recommender.service.impl.RecommenderServiceImpl;

@Component
public class Recommender {

    public static GenericUserBasedRecommender recommender = null;
    public static GenericItemBasedRecommender itemrecommender = null;
    @Autowired
    RecommenderServiceImpl recommenderService;

    private GenericUserBasedRecommender buildRecommender(File file) {
        DataModel model = null;
        try {
            model = new FileDataModel(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserSimilarity similarity = null;
        try {
            similarity = new PearsonCorrelationSimilarity(model);
        } catch (TasteException e) {
            e.printStackTrace();
        }
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0, similarity, model);
        recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        return recommender;
    }

    public GenericUserBasedRecommender getRecommender() {
        if (recommender != null) {
            return recommender;
        } else {
            recommender = buildRecommender(recommenderService.getParsedDataFile());
            return recommender;
        }
    }

    private GenericItemBasedRecommender buildItemRecommender(File file) throws TasteException {
        DataModel model = null;
        try {
            model = new FileDataModel(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);// 计算内容相似度
        GenericItemBasedRecommender itemrecommender = new GenericItemBasedRecommender(model, similarity);// 构造推荐引擎
        return itemrecommender;
    }

    public GenericItemBasedRecommender getitemRecommender() throws TasteException {
        if (itemrecommender != null) {
            return itemrecommender;
        } else {
            itemrecommender = buildItemRecommender(recommenderService.getParsedDataFile());
            return itemrecommender;
        }
    }

    public void renewRecommender() {
        recommender = buildRecommender(recommenderService.getParsedDataFile());
        try {
            itemrecommender = buildItemRecommender(recommenderService.getParsedDataFile());
        } catch (TasteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
