package com.ltp.composite.parser;

import com.ltp.composite.model.ContainerToken;
import com.ltp.composite.model.Token;
import com.ltp.composite.model.TokenType;

import java.util.Arrays;

public class ParagraphParser extends AbstractParser{

    public ParagraphParser(AbstractParser next){
        super(next);
    }

    @Override
    public void parse(Token token, String content) {
        String[] paragraphs = Arrays.stream(content.split("\t")).filter(a -> a.length() > 0).toArray(String[]::new);
        for(String paragraph : paragraphs){
            Token paragraph1 = new ContainerToken(TokenType.PARAGRAPH);
            next.parse(paragraph1, paragraph);
            token.add(paragraph1);
        }
    }
}
