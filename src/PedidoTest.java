import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    Pedido pedido;
    Pizza pizzaVazia;
    @BeforeEach
    public void setUp(){
        pedido = new Pedido();
        pizzaVazia = new Pizza();
        pedido.adicionarPizza(pizzaVazia);
    } 
    @Test 
     public void adicionaVariasPizzasRecorrentes(){
        ///act
        int quantidade = pedido.adicionarPizza(new Pizza());
        //assert
        assertEquals(2, quantidade);
        
     }
    
    @Test
    public void naoAdicionaPizzaEmPedidoFechado(){
        //Arrange
        pedido.fecharPedido();

        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
    
        //Assert
        assertEquals(1, quantidade);
    }
    @Test 
    public void calculaValorPedidoCorretamente(){
        //act
        double preco = pedido.precoAPagar();
        //assert
        assertEquals(29d, preco, 0.01);
    }
    @Test 
    public void CalcularPrecoPedidoComVariasPizzas(){
        //arrange
        Pizza pizza1Igrediente = new Pizza(1);
        pedido.adicionarPizza(pizza1Igrediente);
        //act
        double preco= pedido.precoAPagar();
        //assert
        assertEquals(63d, preco, 0.01);
    }
    @Test 
    public void RelatorioPedido(){
        //Act
        String cupom = pedido.relatorio();
        //assert
        assertTrue(
            cupom.contains("29,00") &&
            cupom.contains("1 pizzas")&&
            cupom.contains("aberto")
        );
    }
}

    

