package io.twasyl.demo.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Thierry Wasylczenko
 * @version 1.0
 */
public class Generator {
    private boolean numberAllowed;
    private boolean lowerCaseAllowed;
    private boolean upperCaseAllowed;
    private int length;

    public void setNumberAllowed(boolean numberAllowed) {
        this.numberAllowed = numberAllowed;
    }

    public void setLowerCaseAllowed(boolean lowerCaseAllowed) {
        this.lowerCaseAllowed = lowerCaseAllowed;
    }

    public void setUpperCaseAllowed(boolean upperCaseAllowed) {
        this.upperCaseAllowed = upperCaseAllowed;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String generate() {
        final List<Character> characters = this.getAllowedCharacters();
        final Random random = new Random();

        final StringBuilder password = new StringBuilder();

        for(int index = 0; index < this.length; index++) {
            final int charIndex = random.nextInt(characters.size());
            password.append(characters.get(charIndex));
        }

        return password.toString();
    }

    private List<Character> getAllowedCharacters() {
        final List<Character> characters = new ArrayList<>();

        if(this.numberAllowed) {
            for(int c = 48; c <= 57; c++) {
                characters.add((char) c);
            }
        }

        if(this.lowerCaseAllowed) {
            for(int c = 97; c <= 122; c++) {
                characters.add((char) c);
            }
        }

        if(this.upperCaseAllowed) {
            for(int c = 65; c <= 90; c++) {
               characters.add((char) c);
            }
        }

        Collections.shuffle(characters);

        return characters;
    }
}
