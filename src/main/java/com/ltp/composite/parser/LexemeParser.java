package com.ltp.composite.parser;

import com.ltp.composite.model.ContainerPart;
import com.ltp.composite.model.SymbolPart;
import com.ltp.composite.model.Part;
import com.ltp.composite.model.PartType;

public class LexemeParser extends AbstractParser{

    public LexemeParser(AbstractParser next){
        super(next);
    }

    @Override
    public void parse(Part part, String content) {
        String[] lexemes = content.split(" ");
        for(String lexeme : lexemes){
            Part lexeme1 = new ContainerPart(PartType.LEXEME);
            next.parse(lexeme1, lexeme.replaceAll(",", ""));
            if(lexeme.endsWith(",")){
                lexeme1.add(new SymbolPart(','));
            }
            part.add(lexeme1);
        }
    }
}
