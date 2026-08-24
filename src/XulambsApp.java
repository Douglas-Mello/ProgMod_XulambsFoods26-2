
import java.util.LinkedList;
import java.util.List;


public class XulambsApp {
    static List<Pizza> pizzas;
        private void cabecalho(){
            IO.println("XULAMBS PIZZA v0.1");
            IO.println("=================");
        }
        private int menuPrincipal() {
            cabecalho();
            IO.println("1-Comprar pizza");
            IO.println("2-Ver pizza vendida");
            IO.println("0-Finalizar");
            return Integer.parseInt(IO.readln("Escolha sua opção: "));
        }

         private int escolherAdicionais() {
            return Integer.parseInt(IO.readln("Quantos adicionais: "));
    }

     private void mostrarNota(Pizza pizza) {
        IO.println("###################");
        IO.println(pizza.gerarCupom());
        IO.println("###################");
    }


    private void comprarPizza() {
        cabecalho();
        IO.println("Comprando pizzas");
        int adicionais = escolherAdicionais();
        Pizza pizza= new Pizza(adicionais);
        mostrarNota(pizza);
        pizzas.add(pizza);
    }
     private void mostrarPizzas() {
        IO.println();

        for (Pizza pizza : pizzas) {
            mostrarNota(pizza);
            IO.println();
            
        }
    }



    void main() {
        int opcao;
        pizzas = new LinkedList<>();
        do {
            opcao = menuPrincipal();
            switch (opcao) {
                case 1 ->
                    comprarPizza();
                case 2 ->
                    mostrarPizzas();
                case 0 ->
                    IO.println("Encerrando!!");
                default ->
                    IO.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
 
    
}

