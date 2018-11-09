package br.converters;
import java.text.*;
import java.util.Date;

import cucumber.api.Transformer;

public class DateConverter extends Transformer<Date>{

	@Override
	public Date transform(String arg0) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date retorno = format.parse(arg0);
			return retorno;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
