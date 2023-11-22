package com.andesec.crypto;

public interface Crypto {

  public String encrypt(String plaintext);

  public String decrypt(String ciphertext);

}
