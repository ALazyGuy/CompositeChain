package com.ltp.composite.comparator;

import com.ltp.composite.model.ContainerPart;
import com.ltp.composite.model.Part;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<Part> {

    @Override
    public int compare(Part o1, Part o2) {
        int size1 = ((ContainerPart)o1).getParts().size();
        int size2 = ((ContainerPart)o2).getParts().size();
        return size1 < size2 ? -1 : size1 == size2 ? 0 : 1;
    }
}
