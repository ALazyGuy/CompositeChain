package com.ltp.composite.service;

import com.ltp.composite.model.ContainerToken;

public interface FilteringService {
    void filterByWords(ContainerToken text, int count);
}
