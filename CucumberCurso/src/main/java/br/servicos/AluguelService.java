package br.servicos;

import br.entidades.Filme;
import br.entidades.NotaAluguel;
import br.utils.DateUtil;

public class AluguelService {

	public NotaAluguel alugar(Filme filme){
		if(filme.getEstoque()==0) 
			throw new RuntimeException("Filme sem estoque");
		
		NotaAluguel nota = new NotaAluguel();
		nota.setPreco(filme.getAluguel());
		nota.setDataEntrega(DateUtil.obterDataDiferencaDias(1));
		filme.setEstoque(filme.getEstoque() -1);
		return nota;
	}
}
