import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprenderCucumber {
	
	@Dado("^que criei o arquivo corretamento$")
	public void queCrieiOArquivoCorretamento() throws Throwable {
	}

	@Quando("^executá-lo$")
	public void executáLo() throws Throwable {
	}

	@Então("^a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable {
	}
	
	private int contador = 0;
	
	@Dado("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int arg1) throws Throwable {
		contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
		contador = contador + arg1;
	}

	@Então("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSerá(int arg1) throws Throwable {
		Assert.assertEquals(arg1, contador);
		//throw new RuntimeException(); 
	}
	
	Date entrega = new Date();
	
	@Dado("^que a entrega é dia (\\d+)/(\\d+)/(\\d+)$")
	public void queAEntregaÉDia(int dia, int mes, int ano) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, dia);
		cal.set(Calendar.MONTH, mes);
		cal.set(Calendar.YEAR, ano);
		entrega = cal.getTime();
	}

	@Quando("^a entega atrasar em (\\d+) dias$")
	public void aEntegaAtrasarEmDias(int arg1) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		cal.add(Calendar.DAY_OF_MONTH, arg1);
		entrega = cal.getTime();
	}

	@Então("^a entrega serra efetuada em (\\d{2}\\/\\d{2}/\\d{4}$")
	public void aEntregaSerraEfetuadaEm(String data) throws Throwable {
		DateFormat format =new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(entrega);
		Assert.assertEquals(data, dataFormatada);
	}


}
