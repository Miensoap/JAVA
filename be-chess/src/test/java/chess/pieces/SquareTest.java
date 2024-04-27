package chess.pieces;

import chess.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static chess.pieces.Square.getSquare;
import static org.assertj.core.api.Assertions.*;

class SquareTest {

    @ParameterizedTest
    @CsvSource(value = {"a1,7,0" , "a8,0,0" , "h1,7,7" , "h8,0,7" , "c1,7,2"})
    @DisplayName("기보 문자열을 알맞은 랭크 , 파일 인덱스로 변환할 수 있어야 한다")
    void getStringSquare(String position , int rankIndex , int fileIndex) {
        Square test = getSquare(position);
        assertThat(test.rankIndex()).isEqualTo(rankIndex);
        assertThat(test.fileIndex()).isEqualTo(fileIndex);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,7,0" , "8,1,0,0" , "1,8,7,7" , "8,8,0,7"})
    @DisplayName("1~8 범위의 랭크,파일 번호를  알맞은 인덱스로 변환할 수 있어야 한다")
    void getRawSquare(int intRank , int intFile , int rankIndex , int fileIndex) {
        Square test = getSquare(intRank , intFile);
        assertThat(test.rankIndex()).isEqualTo(rankIndex);
        assertThat(test.fileIndex()).isEqualTo(fileIndex);
    }

    @Test
    @DisplayName("시작 위치와 이동 방향으로 알맞은 도착 랭크 , 파일 인덱스를 가지는 Square 를 얻을 수 있어야 한다")
    void getDirectionSquare() {
        Square test = getSquare(getSquare("a1"), Direction.NORTH);
        assertThat(test.rankIndex()).isEqualTo(6);
        assertThat(test.fileIndex()).isEqualTo(0);
    }

    @Test
    @DisplayName("보드 범위를 넘어가는 Square 는 얻을 수 없어야 한다")
    void getInvalid(){
        assertThatThrownBy(() -> getSquare(getSquare("a1"), Direction.SOUTHEAST)).isInstanceOf(IllegalArgumentException.class);
    }
}