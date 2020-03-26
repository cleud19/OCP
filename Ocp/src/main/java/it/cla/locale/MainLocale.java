package it.cla.locale;

import java.util.Locale;

public class MainLocale {

	public static void main(String[] args) {
		getThisLocale();

	}
	static void getThisLocale(){
		Locale locale = Locale.getDefault();
		System.out.println(locale);
	}
}
