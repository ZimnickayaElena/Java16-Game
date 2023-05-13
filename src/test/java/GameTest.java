import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testFirstPlayerWin() {
        Player olya = new Player(1, "Olya", 50);
        Player vanya = new Player(2, "Vanya", 200);
        Game game = new Game();

        game.register(olya);
        game.register(vanya);

        int expected = 1;
        int actual = game.round("Vanya", "Olya");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSecondPlayerWin() {
        Player olya = new Player(1, "Olya", 50);
        Player vanya = new Player(2, "Vanya", 200);
        Game game = new Game();

        game.register(olya);
        game.register(vanya);

        int expected = 2;
        int actual = game.round("Olya", "Vanya");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testNobodyWin() {
        Player olya = new Player(1, "Olya", 200);
        Player vanya = new Player(2, "Vanya", 200);
        Game game = new Game();

        game.register(olya);
        game.register(vanya);

        int expected = 0;
        int actual = game.round("Vanya", "Olya");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testFirstPlayerNotRegister() {
        Player olya = new Player(1, "Olya", 50);
        Player vanya = new Player(2, "Vanya", 200);
        Game game = new Game();

        game.register(olya);
        game.register(vanya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
            game.round("Lena", "Vanya");
                });
    }

    @Test
    public void testSecondPlayerNotRegister() {
        Player olya = new Player(1, "Olya", 50);
        Player vanya = new Player(2, "Vanya", 200);
        Game game = new Game();

        game.register(olya);
        game.register(vanya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    game.round("Olya", "Dima");
                });
    }

    @Test
    public void testNobodyNotRegister() {
        Player olya = new Player(1, "Olya", 50);
        Player vanya = new Player(2, "Vanya", 200);
        Game game = new Game();

        game.register(olya);
        game.register(vanya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    game.round("Lena", "Dima");
                });
    }
}
