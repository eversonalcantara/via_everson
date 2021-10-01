package br.com.everson.treinamento.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Rodolpho F. Rodrigues
 */
public class RegexUtils { 

	public static final String PATTERN_HORA_HH_h_MM = "\\d{2}h\\d{2}";
	public static final String PATTERN_dd_MM_yyyy = "(?:(?:(?:0[1-9]|1\\d|2[0-8])\\/(?:0[1-9]|1[0-2])|(?:29|30)\\/(?:0[13-9]|1[0-2])|31\\/(?:0[13578]|1[02]))\\/[1-9]\\d{3}|29\\/02\\/(?:[1-9]\\d(?:0[48]|[2468][048]|[13579][26])|(?:[2468][048]|[13579][26])00))";
	public static final String PATTERN_VALOR_MONETARIO = "R?\\$\\s*(\\d+\\.)*\\d+\\,\\d{2}";
	public static final String PATTERN_PORCENTAGEM = "\\-?\\d+\\,\\d{2}\\%";
	public static final String PATTERN_CONTEUDO = "[\\s\\w\\u00C0-\\u017F]+";
	public static final String PATTERN_NUMERO = "\\d+";
	public static final String PATTERN_PALAVRA = "[a-zA-Z\\u00C0-\\u017F]+";
	public static final String PATTERN_ANY = ".+";
	
	public static String onlyNumbers(String str) {
		return Pattern.compile("\\D").matcher(str).replaceAll("");
	}
	
	public static String extract(String regex, String str) {
		Matcher matcher = Pattern.compile(regex).matcher(str);
		if (matcher.find()) {
			return matcher.group();
		}
		return str;
	}
	
	public static boolean isMatch(String regex, String str) {
		return Pattern.compile(regex).matcher(Pattern.quote(str)).find();
	}
	
	public static boolean isMatchIgnoreCase(String regex, String str) {
		return Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(Pattern.quote(str)).find();
	}
	
}
