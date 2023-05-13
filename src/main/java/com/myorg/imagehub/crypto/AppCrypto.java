package com.myorg.imagehub.crypto;

public interface AppCrypto {
	
	public String encrypt(String data);
	
	public String decrypt(String data);
	
	public String hash(String data);

}
