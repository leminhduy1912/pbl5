package com.pbl5.service.impl;

import com.pbl5.dao.IPromotionDAO;
import com.pbl5.dao.impl.PromotionDAO;
import com.pbl5.models.Promotion;
import com.pbl5.service.IPromotionService;

import java.util.List;

public class PromotionService implements IPromotionService {
    IPromotionDAO dao = new PromotionDAO();
    @Override
    public List<Promotion> findAll() {
        return dao.findAll();
    }

    @Override
    public void createPromotion(Promotion promotion) {
        dao.createPromotion(promotion);
    }

    @Override
    public void deletePromotion(int id) {
        dao.deletePromotion(id);
    }

    @Override
    public void updatePromotion(Promotion promotion) {
        dao.updatePromotion(promotion);
    }
}
