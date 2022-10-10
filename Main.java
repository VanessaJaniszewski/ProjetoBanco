package BancoFucturaVanessa;

public class Main {
	
	public static void main(String[] args) {
		
		ContaCorrente c1 = new ContaCorrente(377, 100.0, "Vanessa J");
		ContaPoupanca p1 = new ContaPoupanca(012, 200.00, "Vanessa Jan.");
		
		
		c1.depositar(20.00);
		c1.ultimaTransacao();
		
		c1.saque(150.00);
		c1.ultimaTransacao();
		
		c1.saque(30.00);
		c1.ultimaTransacao();
		
		p1.aplicar(90.00, c1);
		p1.ultimaTransacao();
		
		p1.resgatar(100.00, c1);
		p1.ultimaTransacao();
		
		p1.aplicar(200.00, c1);
		p1.ultimaTransacao();
		System.out.println(c1.informacaoConta());
		
		p1.resgatar(200.00,c1);
		p1.ultimaTransacao();
		System.out.println(c1.informacaoConta());
		
		p1.resgatar(190.00,c1);
		p1.ultimaTransacao();
		System.out.println(c1.informacaoConta());
	
}}
