package BancoFucturaVanessa;

public abstract class Conta {
	
	
	
	protected Integer numeroConta;
	protected Double saldo;
	protected String nomeTitular ;
	
	
	public Conta(Integer numeroConta, Double saldo, String nomeTitular) {
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.nomeTitular = nomeTitular;
	}
	public Integer getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public Double getSaldo() {
		return saldo;
	}
}
