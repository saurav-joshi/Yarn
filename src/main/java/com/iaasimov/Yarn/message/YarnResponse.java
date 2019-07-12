package com.iaasimov.Yarn.message;

import com.iaasimov.Yarn.entityextraction.EntityExtractionUtil;

import java.util.List;

/**
 * Created by USER on 11-07-2019.
 */
public class YarnResponse {
    public String getOriginalMessage() {
        return originalMessage;
    }

    public void setOriginalMessage(String originalMessage) {
        this.originalMessage = originalMessage;
    }

    public String getYarnResponse() {
        return yarnResponse;
    }

    public void setYarnResponse(String yarnResponse) {
        this.yarnResponse = yarnResponse;
    }

    public List<EntityExtractionUtil.EntityExtractionResult> getListEntities() {
        return listEntities;
    }

    public void setListEntities(List<EntityExtractionUtil.EntityExtractionResult> listEntities) {
        this.listEntities = listEntities;
    }

    private String originalMessage;
    private String yarnResponse;
    private List<EntityExtractionUtil.EntityExtractionResult> listEntities;
}
