package com.tuenti.challenge11.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class AESResolver {

	private String[] keys = { "a", "A", "b", "B", "c", "C", "d", "D", "e", "E",
			"f", "F", "g", "G", "h", "H", "i", "I", "j", "J", "k", "K", "l",
			"L", "m", "M", "n", "N", "o", "O", "p", "P", "q", "Q", "r", "R",
			"s", "S", "t", "T", "u", "U", "v", "V", "w", "W", "x", "X", "y",
			"Y", "z", "Z" };

	public String resolveKey(String userID, String userKey) {

		for (int i = 0; i < keys.length; i++) {
			for (int j = 0; j < keys.length; j++) {
				for (int k = 0; k < keys.length; k++) {
					try {
						String key = userKey + keys[i] + keys[j] + keys[k];
						String encryptedText = getEncryptedContent(userID);
						String decrypted = AES.decrypt(encryptedText, key);
						String timestampkey = getTimestampContent(userID);
						if (decrypted.contains(userID) ||decrypted.contains(timestampkey)){
							System.out.println(decrypted);
						}

						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
		return null;
	}

	private String getEncryptedContent(String userId) throws IOException {
		return getFilecontent(getEncryptedFilename(userId));
	}

	private String getTimestampContent(String userId) throws IOException {
		return getFilecontent(getTimestampFilename(userId));
	}

	private String getEncryptedFilename(String userId) {
		Integer user = Integer.parseInt(userId);
		Integer folder = user % 100;

		return "/data/encrypted/" + folder + "/" + userId + ".feed";
	}

	private String getTimestampFilename(String userId) {
		Integer user = Integer.parseInt(userId);
		Integer folder = user % 100;

		return "/data/last_times/" + folder + "/" + userId + ".timestamp";
	}

	private String getFilecontent(String StringFile) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader br;
		String line;

		br = new BufferedReader(new InputStreamReader(getClass()
				.getResourceAsStream(StringFile), Charset.forName("UTF-8")));

		while ((line = br.readLine()) != null) {

			sb.append(line);

		}

		// Done with the file
		br.close();
		br = null;
		return sb.toString();

	}
}
