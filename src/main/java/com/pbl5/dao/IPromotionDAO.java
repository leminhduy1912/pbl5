package com.pbl5.dao;

import com.pbl5.models.Promotion;

import java.util.List;

public interface IPromotionDAO {
    List<Promotion> findAll();
    void createPromotion(Promotion promotion);
    void deletePromotion(int id);
    void updatePromotion(Promotion promotion);
}
