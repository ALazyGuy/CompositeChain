package com.ltp.composite.parser;

import com.ltp.composite.model.ContainerPart;
import com.ltp.composite.model.Part;
import com.ltp.composite.model.PartType;

public class WordParser extends AbstractParser{

    public WordParser(AbstractParser next){
        super(next);
    }

    @Override
    public void parse(Part part, String content) {
        String[] words = content.split("\\s");
        for(String word : words){
            Part part1 = new ContainerPart(Character.isLetter(word.charAt(0)) ? PartType.WORD : PartType.EXPRESSION);
            next.parse(part1, word);
            part.add(part1);
        }
    }
}
