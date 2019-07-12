package com.iaasimov.Yarn.workflow;

import com.google.common.collect.Lists;
import com.iaasimov.Yarn.entityextraction.EntityExtractionUtil;
import com.iaasimov.Yarn.message.YarnMessage;
import com.iaasimov.Yarn.message.YarnMessage;

import java.util.Arrays;
import java.util.List;

public class ConstructGraph {
    private static ConstructGraph ourInstance = new ConstructGraph();
    private static EntityExtractionUtil entityExtractionUtil;

    public static ConstructGraph constructDAG() {
        if (ourInstance == null) {
            ourInstance = new ConstructGraph();

        }
        return ourInstance;
    }

    private ConstructGraph() {
        SynonymMappingAndLemmatization.init(GlobalConstants.synonymMappingFilePath);
        entityExtractionUtil = new EntityExtractionUtil(SynonymMappingAndLemmatization.synMapping.keySet()).caseInsensitive().lemmatizePatterns().loadEntityExtractions();
        ourInstance.entityExtractionUtil.getEntityExtractionList().forEach(e -> e.setEntityName("$" + e.getName().toLowerCase()));
        LibraryUtil.init();

        System.out.println("Graph has been constructed ....");
    }

    public List<EntityExtractionUtil.EntityExtractionResult> entityExtraction(YarnMessage doc){

        List<String> patternWords = Lists.newLinkedList(Arrays.asList(doc.getText().toLowerCase().split("\\s+")));
        List<EntityExtractionUtil.EntityExtractionResult> entityExtractionResults = entityExtractionUtil.extractEntity(patternWords.stream().toArray(String[]::new));

        List<EntityExtractionUtil.EntityExtractionResult> selectEEResults = EntityExtractionUtil.mergeIntervals(entityExtractionResults);

        System.out.println("Entity Extraction: "+ entityExtractionResults);
        return selectEEResults;

    }


}
