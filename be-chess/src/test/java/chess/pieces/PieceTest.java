package chess.pieces;

import chess.Color;
import chess.pieces.Piece.Type;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("생성자에 입력한 색상의 기물이 생성되어야 하고 , 색상에 따른 표시 문자가 설정되어야 한다.")
    void create() {
        verifyPiece(PieceFactory.createWhitePawn(), Color.WHITE , Type.PAWN.getRepresentation());
        verifyPiece(PieceFactory.createBlackPawn(), Color.BLACK, String.valueOf((char)(Type.PAWN.getRepresentation().charAt(0)+6)));
        verifyPiece(PieceFactory.createBlank(), Color.NOCOLOR, Type.BLANK.getRepresentation());
    }

    private void verifyPiece(Piece piece, final Color color, final String representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("기물의 색상을 구분할 수 있어야 한다")
    void isThatColor(){
        Piece whitePawn = PieceFactory.createWhitePawn();
        assertThat(whitePawn.isWhite()).isTrue();
        Piece blackPawn = PieceFactory.createBlackPawn();
        assertThat(blackPawn.isBlack()).isTrue();
    }
}


