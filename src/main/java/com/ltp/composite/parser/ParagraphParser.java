package com.ltp.composite.parser;

import com.ltp.composite.model.ContainerPart;
import com.ltp.composite.model.Part;
import com.ltp.composite.model.PartType;

import java.util.Arrays;

public class ParagraphParser extends AbstractParser{

    public ParagraphParser(AbstractParser next){
        super(next);
    }

    @Override
    public void parse(Part part, String content) {
        String[] paragraphs = Arrays.stream(content.split("\t")).filter(a -> a.length() > 0).toArray(String[]::new);
        for(String paragraph : paragraphs){
            Part paragraph1 = new ContainerPart(PartType.PARAGRAPH);
            next.parse(paragraph1, paragraph);
            part.add(paragraph1);
        }
    }
}
