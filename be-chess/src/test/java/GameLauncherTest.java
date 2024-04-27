import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class GameLauncherTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    InputStream inputStreamCaptor;
    final PrintStream output = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(output);
    }

    @Test
    @DisplayName("시작 명령을 하지 않은 상태에서 이동 명령을 입력하면 실패해야 한다")
    void noGameMove() {
        inputStreamCaptor = new ByteArrayInputStream("move a2 a3\nend".getBytes());
        System.setIn(inputStreamCaptor);
        System.setOut(new PrintStream(outputStreamCaptor));

        GameLauncher.runChessCmd();

        assertThat(outputStreamCaptor.toString()).contains("Chess>> 잘못된 명령입니다");
    }

    @Test
    @DisplayName("시작 명령을 한 번 한 후로는 다시 시작 명령을 입력할 수 없다")
    void alreadyStarted() {
        inputStreamCaptor = new ByteArrayInputStream("start\nstart\nend".getBytes());
        System.setIn(inputStreamCaptor);
        System.setOut(new PrintStream(outputStreamCaptor));

        GameLauncher.runChessCmd();

        assertThat(outputStreamCaptor.toString()).contains("Chess>> 잘못된 명령입니다");
    }

    @Test
    @DisplayName("이동 명령은 입력 형식에 맞게 입력해야만 수행한다")
    void illegalMoveCmd() {
        inputStreamCaptor = new ByteArrayInputStream("start\nmove a2 a3 a4 a6 a7\nend".getBytes());
        System.setIn(inputStreamCaptor);
        System.setOut(new PrintStream(outputStreamCaptor));

        GameLauncher.runChessCmd();

        assertThat(outputStreamCaptor.toString()).contains("Chess>> 잘못된 명령입니다");
    }
}