package chess;

import chess.pieces.Piece;
import chess.pieces.PieceFactory;
import chess.pieces.Square;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import static chess.ChessHelp.*;

public class Board {
    private final List<Rank> board = new ArrayList<>(MAX_RANK);

    public Board() {
        for (int rank = MIN_RANK; rank <= MAX_RANK; rank++) board.add(new Rank());
    }

    // 초기화
    public void init() {
        fillRank(8, blackPieceSequence);
        fillRank(7, getFillSame(PieceFactory::createBlackPawn));
        fillRank(2, getFillSame(PieceFactory::createWhitePawn));
        fillRank(1, whitePieceSequence);
    }

    private void fillRank(int rank, List<Supplier<Piece>> createPiece) {
        for (int file = MIN_FILE; file <= MAX_FILE; file++) {
            board.get(MAX_RANK - rank).setPiece(file - 1, createPiece.get(file - MIN_FILE).get());
        }
    }

    private List<Supplier<Piece>> getFillSame(Supplier<Piece> createPiece) {
        List<Supplier<Piece>> toReturn = new ArrayList<>(MAX_FILE);
        for (int i = MIN_FILE; i <= MAX_FILE; i++) toReturn.add(createPiece);
        return toReturn;
    }

    public void movePiece(Square start, Square target, Color color) throws IllegalArgumentException {
        Piece movingPiece = findPiece(start);

        // 현재 차례인 플레이어의 기물이 아니면 예외 발생
        if (movingPiece.getColor() != color) throw new IllegalArgumentException("not your Piece");

        List<Square> pieceCanMove = movingPiece.getAvailableSquares(start, this); // 보드 범위 내 가능한 모든 위치

        // 이동 실패 -> 예외 발생
        if (!pieceCanMove.contains(target)) throw new IllegalArgumentException(movingPiece.getRepresentation() + " fail to move");

        // 이동 실행
        addPieceAt(start, PieceFactory.createBlank());
        addPieceAt(target, movingPiece);
        System.out.println(movingPiece.getRepresentation() + start + " moved to " + target);
    }

    public Piece findPiece(Square square) throws IndexOutOfBoundsException {
        return board.get(square.rankIndex()).getPiece(square.fileIndex());
    }

    int countPiece(Color color, Piece.Type type) {
        return (int) board.stream().mapToLong(rank -> rank.stream()
                .filter(p -> p.getColor() == color && p.getType().equals(type))
                .count()).sum();
    }
    void addPieceAt(Square square, Piece piece) {
        board.get(square.rankIndex()).setPiece(square.fileIndex(), piece);
    }
    public List<Rank> getBoard() {
        return Collections.unmodifiableList(board);
    }
}
