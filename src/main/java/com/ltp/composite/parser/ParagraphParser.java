package com.ltp.composite.parser;

import com.ltp.composite.model.ContainerToken;
import com.ltp.composite.model.Token;
import com.ltp.composite.model.TokenType;

public class ParagraphParser extends AbstractParser{

    public ParagraphParser(AbstractParser next){
        super(next);
    }

    @Override
    public void parse(Token token, String content) {
        String[] paragraphs = content.split("\t");
        for(String paragraph : paragraphs){
            Token paragraph1 = new ContainerToken(TokenType.PARAGRAPH);
            next.parse(paragraph1, paragraph);
            token.add(paragraph1);
        }
    }
}
