package com.iaasimov.Yarn.controller;

import com.google.common.collect.Lists;
import com.iaasimov.Yarn.entityextraction.EntityExtractionUtil;

import com.iaasimov.Yarn.message.YarnMessage;
import com.iaasimov.Yarn.message.YarnResponse;
import com.iaasimov.Yarn.workflow.ConstructGraph;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse;
import org.apache.solr.client.solrj.response.SuggesterResponse;
import org.apache.solr.client.solrj.response.Suggestion;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;



@RestController
public class YarnRestController {


    @RequestMapping(value ="/untangle", method = RequestMethod.POST)
    public Object parseText(@RequestBody YarnMessage message)
    {
        List<EntityExtractionUtil.EntityExtractionResult> l = ConstructGraph.constructDAG().entityExtraction(message);

        YarnResponse res = new YarnResponse();
        res.setOriginalMessage(message.getText());
        res.setListEntities(l);
        res.setYarnResponse(l.toString());

        return res;

    }



}