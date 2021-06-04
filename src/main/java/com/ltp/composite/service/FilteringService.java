package com.ltp.composite.service;

import com.ltp.composite.model.ContainerPart;

public interface FilteringService {
    void filterByWords(ContainerPart text, int count);
}
