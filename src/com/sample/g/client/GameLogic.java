package com.sample.g.client;

public class GameLogic {
	/* This is the maximum number of incorrect guesses. */
	public final int maxTries = 5;
	/* This is the maximum length of a secret word. */
	public final int maxWordLen = 20;
	/* This buffer holds the letters in the secret word. */
	public char secretWord[];
	/* This is the length of the secret word. */
	public int secretWordLen;
	/*
	 * This buffer holds the letters which the user typed but don't appear in
	 * the secret word.
	 */
	public char wrongLetters[];
	/* This is the current number of incorrect guesses. */
	public int wrongLettersCount;
	/*
	 * This buffer holds letters that the user has successfully guessed.
	 */
	public char word[];
	/* Number of correct letters in 'word'. */
	public int wordLen;
	
	
	private GameListener gameListener;
	
	public interface GameListener{
		void onCorrectWord();
		void onWrongWord();
		void onWin();
		void onLose();
		void onExistingWord();
	}

	public GameLogic() {
		wrongLettersCount = 0;
		wrongLetters = new char[maxTries];
		secretWordLen = 0;
		secretWord = new char[maxWordLen];
		word = new char[maxWordLen];
	}
	
	public void setGameListener(GameListener gameListener){
		this.gameListener = gameListener;
	}

	public void newGame() {
		int i;
		// pick secret word
		String s = wordlist[(int) Math.floor(Math.random() * wordlist.length)];
		secretWordLen = Math.min(s.length(), maxWordLen);
		for (i = 0; i < secretWordLen; i++) {
			secretWord[i] = s.charAt(i);
		}
		// clear word buffers
		for (i = 0; i < maxWordLen; i++) {
			word[i] = 0;
		}
		wordLen = 0;
		for (i = 0; i < maxTries; i++) {
			wrongLetters[i] = 0;
		}
		wrongLettersCount = 0;
	}

	public boolean keydown(int key) {
		int i;
		boolean found = false;
		// start new game if user has already won or lost.
		if (secretWordLen == wordLen || wrongLettersCount == maxTries) {
			newGame();
			return true;
		}
		// check if valid letter
		if (key < 'a' || key > 'z') {
			// play(getCodeBase(), "rsrc/beep.au");
			return true;
		}
		// check if already in secret word
		for (i = 0; i < secretWordLen; i++) {
			if (key == word[i]) {
				found = true;
				if(gameListener != null)
					gameListener.onExistingWord();
				return true;
			}

		}
		// check if already in wrongLetters
		if (!found) {
			for (i = 0; i < maxTries; i++) {
				if (key == wrongLetters[i]) {
					found = true;
					// play(getCodeBase(), "rsrc/ding.au");
					if(gameListener != null)
						gameListener.onExistingWord();

					return true;
				}
			}
		}
		// is letter in secret word? If so, add it.
		if (!found) {
			for (i = 0; i < secretWordLen; i++) {
				if (key == secretWord[i]) {
					word[i] = (char) key;
					wordLen++;
					found = true;
				}
			}
			if (found) {
				if (wordLen == secretWordLen) {
					// play(getCodeBase(), "rsrc/whoopy.au");
					if(gameListener != null)
						gameListener.onWin();

					// startDukeDancing();
				} else {
					// play(getCodeBase(), "rsrc/ah.au");
					if(gameListener != null)
						gameListener.onCorrectWord();
				}
			}
		}
		// wrong letter; add to wrongLetters
		if (!found) {
			if (wrongLettersCount < wrongLetters.length) {
				wrongLetters[wrongLettersCount++] = (char) key;
				if (wrongLettersCount < maxTries) {
					// play(getCodeBase(), "rsrc/ooh.au");
					if(gameListener != null)
						gameListener.onWrongWord();

				} else {
					// show the answer
					for (i = 0; i < secretWordLen; i++) {
						word[i] = secretWord[i];
					}
					// play(getCodeBase(), "rsrc/scream.au");
					//onlose listeners
					if(gameListener != null)
						gameListener.onLose();
				}
			}
		}

		if (wordLen == secretWordLen) {
			// danceSequenceNum = -1;
		}
		return true;

	}

	String wordlist[] = {

	"abstraction",

	"ambiguous",

	"arithmetic",

	"backslash",

	"bitmap",

	"circumstance",

	"combination",

	"consequently",

	"consortium",

	"decrementing",

	"dependency",

	"disambiguate",

	"dynamic",

	"encapsulation",

	"equivalent",

	"expression",

	"facilitate",

	"fragment",

	"hexadecimal",

	"implementation",

	"indistinguishable",

	"inheritance",

	"internet",

	"java",

	"localization",

	"microprocessor",

	"navigation",

	"optimization",

	"parameter",

	"patrick",

	"pickle",

	"polymorphic",

	"rigorously",

	"simultaneously",

	"specification",

	"structure",

	"lexical",

	"likewise",

	"management",

	"manipulate",

	"mathematics",

	"hotjava",

	"vertex",

	"unsigned",

	"traditional" };

}
