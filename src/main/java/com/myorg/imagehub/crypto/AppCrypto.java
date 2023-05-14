package com.myorg.imagehub.crypto;

public interface AppCrypto {
	
	public String encrypt(String data);
	
	public String decrypt(String data);
	
	public String encodePassword(String data);
	
	public boolean verifyPassword(String plain, String hashed);

}
