import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.sun.tools.javac.util.List;

import aula1.Lance;
import aula1.Leilao;
import aula1.Usuario;
import aula1.servico.Avaliador;

public class AvaliadorTest {
	
	@Test
	public void devemEntenderLancesCrescentes() {
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		Usuario jose = new Usuario("José");
		
		Leilao leilao = new Leilao("Porduto X");
		
		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(maria, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		Assert.assertEquals(400, avaliador.getMaiorLance(), 0.00001);
		Assert.assertEquals(250, avaliador.getMenorLance(), 0.00001);
		
	}
	
	@Test
	public void deveRetornarMediaLances() {
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		Usuario jose = new Usuario("José");
		
		Leilao leilao = new Leilao("Porduto X");
		
		List<Lance> listaLances = new ArrayList<Lance>();
		listaLances.add(new Lance(joao, 250.0));
		listaLances.add(new Lance(maria, 300.0));
		listaLances.add(new Lance(jose, 400.0));
		
		Double total = 0.0;
		for(Lance lance: listaLances) {
			leilao.propoe(lance);
			total += lance.getValor();
		}
		
		Double media = total / listaLances.size();
		
		Avaliador avaliador = new Avaliador();	
		Assert.assertEquals(media, avaliador.avaliaMedia(leilao), 0.00001);

	}
}
