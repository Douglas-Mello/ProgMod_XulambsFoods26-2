import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PizzaTest {
    Pizza pizza;
    
    @BeforeEach
    public void setUp(){
        //Arrange
        pizza = new Pizza();
        pizza.adicionarIngredientes(2);
    }

    @Test
    public void adicionaIngredientesCorretamente(){
        //Act
        int quantos = 
            pizza.adicionarIngredientes(4);

        //Assert
        assertEquals(6, quantos);
    }
    @Test
    public void naoAdicionaIgredienteNegativo(){
       
        //Act
        int quantidade = pizza.adicionarIngredientes(-67);

        //Assert
        assertEquals(2,quantidade);

    }
    @Test
    public void naoUltrapassaMaxIngredientes(){
         
        //Act
        int quantidade = pizza.adicionarIngredientes(67);

        //Assert
        assertEquals(2, quantidade);

    }
    @Test
    public void calcularPrecoCorretamente(){
      
        //act
        double preco = pizza.valorFinal();
        //assert
        assertEquals(39, preco,0.01);
    }
    
}
