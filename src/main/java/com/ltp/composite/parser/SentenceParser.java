package com.ltp.composite.parser;

import com.ltp.composite.model.ContainerPart;
import com.ltp.composite.model.SymbolPart;
import com.ltp.composite.model.Part;
import com.ltp.composite.model.PartType;

public class SentenceParser extends AbstractParser{

    public SentenceParser(AbstractParser next){
        super(next);
    }

    @Override
    public void parse(Part part, String content) {
        String[] sentences = content.split(SENTENCE_DELIMITER);
        for(String sentence : sentences){
            Part sentence1 = new ContainerPart(PartType.SENTENCE);
            next.parse(sentence1, sentence.replaceAll("[!.?]$", ""));
            sentence1.add(new SymbolPart(sentence.charAt(sentence.length() - 1)));
            part.add(sentence1);
        }
    }
}
