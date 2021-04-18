package Views.Router;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouterTest {

    @Test
    public void testRouterInstantiation(){

        System.out.println("Returns the same router instance at all times");

        // Arrange
        Router router = Router.getInstance();
        Router secondRouter = Router.getInstance();

        // Assert
        assertEquals(router, secondRouter);
    };


}
