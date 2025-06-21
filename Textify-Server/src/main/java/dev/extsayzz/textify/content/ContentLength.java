package dev.extsayzz.textify.content;

public enum ContentLength {

    LENGTH(65536);

    final int length;

    ContentLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }
}
