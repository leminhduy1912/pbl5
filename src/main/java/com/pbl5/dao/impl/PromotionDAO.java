package com.pbl5.dao.impl;

import com.pbl5.dao.IPromotionDAO;
import com.pbl5.helpers.mapper.PromotionMapper;
import com.pbl5.models.Promotion;

import java.util.List;
import java.util.logging.Logger;

public class PromotionDAO extends AbstractDAO<Promotion> implements IPromotionDAO {
    private static final Logger logger = Logger.getLogger("PromotionDAO");
    @Override
    public List<Promotion> findAll() {
        String sql = "select * from promotions";
        List<Promotion> promotionList = query(sql,new PromotionMapper());
        return promotionList;
    }

    @Override
    public void createPromotion(Promotion promotion) {
        String sql = "insert into promotions values(?,?,?,?,?,?,?,?,?,?)";
        insert(sql,promotion.getId(),promotion.getDescription(),promotion.getTitle(),promotion.getNotificationTime(),
                promotion.getStartTime(),promotion.getEndTime(),promotion.getModifiedBy(),promotion.getCreatedAt(),promotion.getCreatedBy(),promotion.getModifiedAt());
    }

    @Override
    public void deletePromotion(int id) {
        String sql = "delete from promotions where id = ?";
        delete(sql,id);
    }

    @Override
    public void updatePromotion(Promotion promotion) {
        String sql = "update promotions set description = ?, title = ?, notificationTime = ?, startTime = ?, endTime = ?, " +
                "modifiedBy = ?, createdAt = ?, createdBy = ?, modifiedAt = ? where promotionId = ?";
        update(sql,promotion.getDescription(),promotion.getTitle(),promotion.getNotificationTime(),
                promotion.getStartTime(),promotion.getEndTime(),promotion.getModifiedBy(),promotion.getCreatedAt(),promotion.getCreatedBy(),promotion.getModifiedAt(), promotion.getId());
    }
}
