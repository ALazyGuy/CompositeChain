package com.ltp.composite.service.impl;

import com.ltp.composite.model.ContainerToken;
import com.ltp.composite.model.Token;
import com.ltp.composite.service.SearchService;

import java.util.Arrays;

public class SearchServiceImpl implements SearchService {

    @Override
    public Token withLongestWord(ContainerToken text) {
        ContainerToken result = null;
        for(Token paragraph : text.getTokens()){
            for(Token sentence : ((ContainerToken)paragraph).getTokens()){
                if(result == null || ((ContainerToken)sentence).getLength() > result.getLength()){
                    result = (ContainerToken)sentence;
                }
            }
        }

        return result;
    }

    @Override
    public long count(String word, ContainerToken text) {
        return Arrays.stream(text.toString().split(" "))
            .map(a -> a.trim().replaceAll("[.!?,]", "").toLowerCase())
            .filter(a -> a.equals(word.toLowerCase()))
            .count();
    }
}
