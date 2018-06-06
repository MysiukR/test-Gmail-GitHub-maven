package com.epam.lab.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PageElementList extends ArrayList<PageElement> {

    public int countTag(List<PageElement> pageElements, String text) {
        return (int) pageElements.stream().filter(tags -> tags.getText().contentEquals(text)).count();
    }

    public List<PageElement> getAllTags(List<PageElement> pageElements, String text) {
        return pageElements.stream().filter(tags -> tags.getText().contentEquals(text)).collect(Collectors.toList());
    }

    public String compareCounters(int countTag, int totalCount, String tagName) {
        String messageText;
        if (countTag != totalCount) {
            messageText = String.format("Not all tags contain '%s'. %d from %d", tagName, countTag, totalCount);
        } else {
            messageText = String.format("All tags contain '%s'!",tagName);
        }
        return messageText;

    }
}
