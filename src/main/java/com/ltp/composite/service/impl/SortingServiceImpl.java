package com.ltp.composite.service.impl;

import com.ltp.composite.comparator.ParagraphComparator;
import com.ltp.composite.model.ContainerToken;
import com.ltp.composite.service.SortingService;

import java.util.Collections;

public class SortingServiceImpl implements SortingService {

    @Override
    public void sortBySentences(ContainerToken text) {
        Collections.sort(text.getTokens(), new ParagraphComparator());
    }
}
