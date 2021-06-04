package com.ltp.composite.service.impl;

import com.ltp.composite.model.ContainerPart;
import com.ltp.composite.model.Part;
import com.ltp.composite.service.SearchService;

import java.util.Arrays;

public class SearchServiceImpl implements SearchService {

    @Override
    public Part withLongestWord(ContainerPart text) {
        ContainerPart result = null;
        for(Part paragraph : text.getParts()){
            for(Part sentence : ((ContainerPart)paragraph).getParts()){
                if(result == null || ((ContainerPart)sentence).getLength() > result.getLength()){
                    result = (ContainerPart)sentence;
                }
            }
        }

        return result;
    }

    @Override
    public long count(String word, ContainerPart text) {
        return Arrays.stream(text.toString().split(" "))
            .map(a -> a.trim().replaceAll("[.!?,]", "").toLowerCase())
            .filter(a -> a.equals(word.toLowerCase()))
            .count();
    }
}
