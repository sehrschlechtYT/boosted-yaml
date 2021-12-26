package com.davidcubesvk.yamlUpdater.core.fvs.segment;

/**
 * Represents an immutable segment constructed directly from an array of elements.
 */
public class LiteralSegment implements Segment {

    //The elements
    private final String[] elements;

    /**
     * Creates a segment with the given elements.
     *
     * @param elements the elements
     */
    public LiteralSegment(String... elements) {
        this.elements = elements;
    }

    @Override
    public int parse(String versionId, int start) {
        //Go through all indexes
        for (int index = 0; index < elements.length; index++) {
            //If the same
            if (versionId.startsWith(elements[index], start))
                //Set
                return index;
        }

        //Cannot parse
        return -1;
    }

    @Override
    public String getElement(int index) {
        return elements[index];
    }

    @Override
    public int getElementLength(int index) {
        return elements[index].length();
    }

    @Override
    public int length() {
        return elements.length;
    }
}