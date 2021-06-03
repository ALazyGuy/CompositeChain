package com.ltp.composite.service;

import com.ltp.composite.model.ContainerToken;
import com.ltp.composite.model.Token;

public interface SearchService {
    Token withLongestWord(ContainerToken text);
    long count(String word, ContainerToken text);
}
