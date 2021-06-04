package com.ltp.composite.comparator;

import com.ltp.composite.model.ContainerToken;
import com.ltp.composite.model.Token;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<Token> {

    @Override
    public int compare(Token o1, Token o2) {
        int size1 = ((ContainerToken)o1).getTokens().size();
        int size2 = ((ContainerToken)o2).getTokens().size();
        return size1 < size2 ? -1 : size1 == size2 ? 0 : 1;
    }
}
