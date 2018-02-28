package sis.util;

class PasswordGenerator {
    private int numberOfCharacters;
    private CharacterGenerator charGenerator;
    
    PasswordGenerator(int numberOfCharacters,
		      CharacterGenerator charGenerator) {
	this.numberOfCharacters = numberOfCharacters;
	this.charGenerator = charGenerator;
    }

    String generatePassword() {
	String password = "";
	for (int i = 0; i < numberOfCharacters; i++)
	    password += charGenerator.next();
	return password;
    }

}
