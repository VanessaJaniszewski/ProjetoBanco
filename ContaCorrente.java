package BancoFucturaVanessa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrente extends Conta{

	public ContaCorrente(Integer numeroConta, Double saldo, String nomeTitular) {
		super(numeroConta, saldo, nomeTitular);
	}

	/*: número da conta, nome do titular, 
saldo disponível e ter métodos para exibir os dados da conta cadastrada, 
fazer depósito, exibir o saldo de cada conta e métodos getters e setters dos 
atributos private
	 */

	private List<String> historico = new ArrayList<>();
	private String mensagem;
	
	

	public void debitar(Double debito) {
		LocalDateTime agora = LocalDateTime.now();
		if(saldo>=debito) {
		saldo -= debito;
		mensagem = "DÉBITO: \nTitular:"+this.getNomeTitular()+"\nConta número: "+this.getNumeroConta()+""
				+ "\no valor de: R$"+debito+"\nSaldo atual: "+this.getSaldo()+"\n "+agora.toString()+"\n";
		}else{
	mensagem = "DÉBITO NEGADO\nSaldo insuficiente. Saldo atual é de R$: "+this.saldo+"\n"+agora.toString()+"\n";
		}
		historico.add(mensagem);
	};
	

	public void depositar(Double credito) {
		this.saldo += credito;
		LocalDateTime agora = LocalDateTime.now();
		mensagem = "DEPÓSITO: \nTitular:"+this.getNomeTitular()+"\nConta número: "+this.getNumeroConta()+""
				+ "\no valor de: R$"+credito+"\nSaldo atual: "+this.getSaldo()+"\n"+agora.toString()+"\n";
		historico.add(mensagem);
	};
	
	public void enviarPoupança (Double valor, ContaPoupanca conta) {
		LocalDateTime agora = LocalDateTime.now();
		if(valor <= this.saldo) {
			conta.aplicar(valor, this);
			this.saldo-=valor;
			mensagem = "ENVIAR PARA POUPANÇA\nValor R$ "+valor+ " enviado com Sucesso para poupança de número :"+conta.getNumeroConta()+"\n"
					+ "O saldo atual é de R$: "+this.saldo+"\n "+agora.toString()+"\n";
		}else {
				mensagem = "ENVIAR PARA POUPANÇA NEGADO\nSaldo insuficiente. Saldo atual é de R$: "+this.saldo+"\n"+agora.toString()+"\n";
			}
		historico.add(mensagem);}
	
	public Boolean saque (Double valor) {
		LocalDateTime agora = LocalDateTime.now();
		if(valor <= this.saldo) {
			this.saldo-=valor;
			mensagem = "SAQUE\nAutorização do saque no valor de R$ "+valor+"\n"
					+ "O saldo atual é de R$: "+this.saldo+"\n"+agora.toString()+"\n";
		}else {
				mensagem = "SAQUE NEGADO\nSaldo insuficiente. Saldo atual é de R$: "+this.saldo+"\n"+agora.toString()+"\n";
			}
		historico.add(mensagem);
		return true;
	}
	

	public String informacaoConta() {
		String info;
		LocalDateTime agora = LocalDateTime.now();
		info ="---CONTA CORRENTE---\nNome do Titular: "+this.nomeTitular+"\n"
				+ "Número da Conta: "+this.getNumeroConta()+"\n"
						+ "Saldo: R$ "+this.getSaldo()+"\n"+agora.toString()+"\n";
		return info;
	};
	
	public void historicoConta() {
		System.out.println("HISTÓRICO DA CONTA:\n"+historico+"\n");
		
	}
	public void ultimaTransacao() {
		System.out.println(historico.get(historico.size()-1)+"\n");
		
	}

}
