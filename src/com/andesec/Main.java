package com.andesec;

import com.andesec.crypto.algorithms.Caesar;
import com.andesec.crypto.Crypto;

public class Main {

  public static void main(String[] args) {
    String algorithm = args[0];
    int key = Integer.parseInt(args[1]);
    String data = args[2];
    Crypto crypto = null;

    switch (algorithm) {
      case "caesar":
        crypto = new Caesar(key);
        System.out.println(crypto.encrypt(data));
        break;
      case "vigenere", "xor":
      default:
        System.out.println("Invalid algorithm");
        return;
    }

    String ciphertext = crypto.encrypt(data);
    System.out.println("Plaintext = " + data);
    System.out.println("Ciphertext = " + ciphertext);
    System.out.println("Decrypted = " + crypto.decrypt(ciphertext));
  }
}