package com.ltp.composite.service.impl;

import com.ltp.composite.model.ContainerPart;
import com.ltp.composite.model.Part;
import com.ltp.composite.service.FilteringService;

public class FilteringServiceImpl implements FilteringService {

    @Override
    public void filterByWords(ContainerPart text, int count) {
        for(int i = 0; i < text.getParts().size(); i++){
            Part paragraph = text.get(i);
            for(int d = 0; d < ((ContainerPart)paragraph).getParts().size(); d++){
                Part sentence = paragraph.get(d);
                if(((ContainerPart)sentence).getParts().size() - 1 < count){
                    paragraph.remove(sentence);
                    d--;
                }
            }
            if(((ContainerPart) paragraph).getParts().size() == 0){
                text.remove(paragraph);
                i--;
            }
        }
    }

}
