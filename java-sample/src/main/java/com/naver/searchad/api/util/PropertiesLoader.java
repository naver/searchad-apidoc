package com.naver.searchad.api.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

	public static Properties fromResource(String resource) throws IOException {
		try (InputStream input = classLoader().getResourceAsStream(resource)) {
			if (input == null) {
				throw new FileNotFoundException(resource);
			}
			Properties properties = new Properties();
			properties.load(input);
			return properties;
		}
	}

	private static ClassLoader classLoader() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		return loader == null ? PropertiesLoader.class.getClassLoader() : loader;
	}

}
