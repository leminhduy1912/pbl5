package com.pbl5.service;

import com.pbl5.models.Promotion;

import java.util.List;

public interface IPromotionService {
    List<Promotion> findAll();
    void createPromotion(Promotion promotion);
    void deletePromotion(int id);
    void updatePromotion(Promotion promotion);
}
