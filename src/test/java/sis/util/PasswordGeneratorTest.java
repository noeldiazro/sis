package sis.util;

import junit.framework.TestCase;

public class PasswordGeneratorTest extends TestCase {
    private static final char TEST_CHAR = 'a';
    private static final String EIGHT_TEST_CHARS = "aaaaaaaa";
    private static final String FOUR_TEST_CHARS = "aaaa";
    
    private CharacterGenerator charGenerator;

    @Override public void setUp() throws Exception {
	super.setUp();
	charGenerator = new FixedCharacterGenerator(TEST_CHAR);
    }
    
    public void testStandardPassword() {
	final int numberOfCharacters = 8;
	PasswordGenerator generator = new PasswordGenerator(numberOfCharacters, charGenerator);

	assertEquals(EIGHT_TEST_CHARS, generator.generatePassword());
    }

    public void testShortPassword() {
	final int numberOfCharacters = 4;
	PasswordGenerator generator = new PasswordGenerator(numberOfCharacters, charGenerator);

	assertEquals(FOUR_TEST_CHARS, generator.generatePassword());
    }

}

class FixedCharacterGenerator implements CharacterGenerator {
    private char fixedCharacter;
    
    FixedCharacterGenerator(char fixedCharacter) {
	this.fixedCharacter = fixedCharacter;
    }
    
    public char next() {
	return fixedCharacter;
    }
}
