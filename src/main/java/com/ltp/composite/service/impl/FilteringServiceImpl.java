package com.ltp.composite.service.impl;

import com.ltp.composite.model.ContainerToken;
import com.ltp.composite.model.Token;
import com.ltp.composite.service.FilteringService;

public class FilteringServiceImpl implements FilteringService {

    @Override
    public void filterByWords(ContainerToken text, int count) {
        for(int i = 0; i < text.getTokens().size(); i++){
            Token paragraph = text.get(i);
            for(int d = 0; d < ((ContainerToken)paragraph).getTokens().size(); d++){
                Token sentence = paragraph.get(d);
                if(((ContainerToken)sentence).getTokens().size() - 1 < count){
                    paragraph.remove(sentence);
                    d--;
                }
            }
            if(((ContainerToken) paragraph).getTokens().size() == 0){
                text.remove(paragraph);
                i--;
            }
        }
    }

}
