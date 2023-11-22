package com.andesec.crypto.algorithms;

import com.andesec.crypto.Crypto;

public class Caesar implements Crypto {

  private static final String CHARACTERS = " ABCDEFGHIJKLMNOPQRSTUVWXYZ123~!@abcdefghijklmnopqrstuvwxyz456#$%7890^&*()_+-=\\|/?.,{}[]`";

  private int key = 0;

  public Caesar(int key) {
    this.key = key;
  }

  public String encrypt(String plaintext) {
    StringBuilder ciphertext = new StringBuilder();

    for (char c : plaintext.toCharArray()) {
      int currentIndex = CHARACTERS.indexOf(c);
      int newIndex = Math.floorMod(currentIndex + key, CHARACTERS.length());

      ciphertext.append(CHARACTERS.charAt(newIndex));
    }
    return ciphertext.toString();
  }

  public String decrypt(String ciphertext) {
    StringBuilder plaintext = new StringBuilder();

    for (char c : ciphertext.toCharArray()) {
      int currentIndex = CHARACTERS.indexOf(c);
      int oldIndex = Math.floorMod(currentIndex - key, CHARACTERS.length());

      plaintext.append(CHARACTERS.charAt(oldIndex));
    }
    return plaintext.toString();
  }
}
