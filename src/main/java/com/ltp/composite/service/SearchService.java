package com.ltp.composite.service;

import com.ltp.composite.model.ContainerPart;
import com.ltp.composite.model.Part;

public interface SearchService {
    Part withLongestWord(ContainerPart text);
    long count(String word, ContainerPart text);
}
