package com.ltp.composite.parser;

import com.ltp.composite.model.SymbolPart;
import com.ltp.composite.model.Part;

public class SymbolParser extends AbstractParser {

    public SymbolParser(){
        super(null);
    }

    @Override
    public void parse(Part part, String content) {
        char[] symbols = content.toCharArray();
        for(char c : symbols){
            part.add(new SymbolPart(c));
        }
    }
}
