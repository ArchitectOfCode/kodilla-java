package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String text, PoemDecorator poemDecorator) {
        String beautifierText = poemDecorator.decorate(text);
        return beautifierText ;
    }
}
