package com.pbl5.helpers.mapper;

import com.pbl5.models.Promotion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PromotionMapper implements IMapper<Promotion> {
    @Override
    public Promotion mapRow(ResultSet result) {
        Promotion promotion = new Promotion();
        try {
            promotion.setId(result.getString("promotionId"));
            promotion.setDescription(result.getString("description"));
            promotion.setTitle(result.getString("title"));
            promotion.setNotificationTime(result.getTimestamp("notificationTime"));
            promotion.setStartTime(result.getTimestamp("startTime"));
            promotion.setEndTime(result.getTimestamp("endTime"));
            promotion.setModifiedBy(result.getString("modifiedBy"));
            promotion.setCreatedAt(result.getTimestamp("createdAt"));
            promotion.setCreatedBy(result.getString("createdBy"));
            promotion.setModifiedAt(result.getTimestamp("modifiedAt"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotion;
    }
}
