package BancoFucturaVanessa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(Integer numeroConta, Double saldo, String nomeTitular) {
		super(numeroConta, saldo, nomeTitular);
		// TODO Auto-generated constructor stub
	}
	
	private List<String> historico = new ArrayList<>();
	private String mensagem;

	
	public void aplicar(Double valor, ContaCorrente conta) {
		LocalDateTime agora = LocalDateTime.now();
		if(conta.saldo >=valor) {
		this.saldo += valor;
		conta.saldo -=valor;
		mensagem = "APLICAÇÃO EM POUPANÇA: \nTitular:"+this.getNomeTitular()+"\nConta número: "+this.getNumeroConta()+""
				+ "\nValor aplicado em poupança: R$"+valor+"\n"+agora.toString()+"\n";
		}else {
			mensagem = "APLICAÇÃO EM POUPANÇA NEGADA\nSaldo insuficiente em Conta Corrente. Saldo atual é de R$: "+conta.saldo+"\n"+agora.toString()+"\n";
		}
		historico.add(mensagem);
	};
	
	
	public void resgatar (Double valor, ContaCorrente conta) {
		LocalDateTime agora = LocalDateTime.now();
		if(valor <= this.saldo) {
			conta.debitar(valor);
			this.saldo-=valor;
			conta.saldo+=valor;
			mensagem = "RESGATE\nValor R$ "+valor+ " enviado com Sucesso para a conta corrente de número :"+conta.getNumeroConta()+"\n"
					 + agora.toString()+ "\n";
		}else {
				mensagem = "RESGATE NEGADO\nSaldo insuficiente. Saldo atual é de R$: "+this.saldo+"\n"+agora.toString()+"\n";
			}
		historico.add(mensagem);}
	
	public String informacaoConta() {
		LocalDateTime agora = LocalDateTime.now();
		String info;
		info="---CONTA POUPANÇA---\nNome do Titular: "+this.nomeTitular+"\n"
				+ "Número da Conta: "+this.getNumeroConta()+"\n"
						+ "Saldo: R$ "+this.getSaldo()+"\n"+agora.toString()+"\n";
		return info;
	}
	
	public void historicoConta() {
		System.out.println("HISTÓRICO DA CONTA:\n"+historico+"\n");
	
	}
	public void ultimaTransacao() {
		System.out.println(historico.get(historico.size()-1)+"\n");
		
	}

		
}
	

		


