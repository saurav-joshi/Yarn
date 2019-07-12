package com.iaasimov.Yarn.message;
import java.util.Date;
import java.util.List;

import com.iaasimov.Yarn.entityextraction.EntityExtractionUtil;
import org.apache.solr.client.solrj.beans.Field;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@SolrDocument(solrCoreName = "iaasimov")

public class YarnMessage
{


    private String entities;

    String text;

    public String getEntities() {
        return entities;
    }

    public void setEntities(List<EntityExtractionUtil.EntityExtractionResult> entities) {

        //this.entities = entities.stream().map(e -> e.toString()).reduce("", String::concat);
        this.entities = entities.stream().map(e ->e.getEntityName()+ ":" + String.join(" ",e.getEntityValue()) + " ")
                                         .reduce("", String::concat);

        System.out.println(this.entities);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public YarnMessage(String text){
        this.text = text;

    }

    public YarnMessage(){

    }

}



