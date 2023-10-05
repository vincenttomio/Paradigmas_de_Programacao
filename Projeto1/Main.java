public class Main {
    public static void main(String[] args) {
        // Instanciando objetos usando construtor completo
        Pagamento pagamentoCartao = new PagamentoEmCartao();
        Pagamento pagamentoPIX = new PagamentoViaPIX();
        Pagamento pagamentoDinheiro = new PagamentoEmDinheiro();

        Cliente turista = new Turista("Turista 1", "Camisetas");
        Cliente moradorLocal = new MoradorLocal("Morador 1", "Canecas", "Endereço 1");

        Produto camiseta = new Camiseta("Camiseta Manga Longa", 29.99, "Manga Longa", "M");
        Produto caneca = new Caneca("Caneca Simples", 9.99, "Cerâmica");

        Venda vendaTurista = new Venda(turista, pagamentoCartao);
        vendaTurista.adicionarItem(camiseta);
        vendaTurista.adicionarItem(caneca);

        Venda vendaMoradorLocal = new Venda(moradorLocal, pagamentoDinheiro);
        vendaMoradorLocal.adicionarItem(camiseta);

        Quiosque quiosque = new Quiosque();
        quiosque.adicionarFuncionario(new Vendedor("Vendedor 1", 1500));
        quiosque.adicionarFuncionario(new Gerente("Gerente 1", 2500));

        quiosque.realizarVenda(vendaTurista);
        quiosque.realizarVenda(vendaMoradorLocal);

        // Armazenando objetos em uma colecao
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(turista);
        clientes.add(moradorLocal);

        // Demonstrando polimorfismo ao iterar sobre a colecao
        for (Cliente cliente : clientes) {
            quiosque.interagirCliente(cliente);
        }

        quiosque.gerarRelatorio();
    }
}