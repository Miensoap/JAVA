import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("생성자에 입력한 색상의 폰이 생성되어야 한다")
    public void create() {
        final String white = "white";
        final String black = "black";

        verifyPawn(white);
        verifyPawn(black);
    }

    private static void verifyPawn(final String color) {
        Pawn blackPawn = new Pawn(color);
        assertThat(blackPawn.getColor()).isEqualTo(color);
    }
}

