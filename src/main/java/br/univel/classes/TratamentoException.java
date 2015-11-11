package br.univel.classes;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class TratamentoException {

	public BigDecimal tratamentoBigDecimal(String valor) throws ParseException, NumberFormatException{
		Number num = NumberFormat.getNumberInstance(Locale.US).parse(valor);
		BigDecimal d = new BigDecimal(num.floatValue());
		return d;

	}
}
