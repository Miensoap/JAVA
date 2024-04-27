package chess;

import chess.pieces.Piece;
import chess.pieces.PieceFactory;
import chess.pieces.Square;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import static chess.ChessHelp.*;
import static chess.pieces.Square.getSquare;

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
        // 홀수 턴일 때 흰색 , 짝수 턴일 때 검은색 이 아니면 예외 발생
        if (movingPiece.getColor() != color) throw new IllegalArgumentException("not your Piece");

        List<Square> pieceCanMove = getAvailableSquares(movingPiece, start); // 보드 범위 내 가능한 모든 위치

        if (!pieceCanMove.contains(target)) throw new IllegalArgumentException(movingPiece.getRepresentation() + " fail to move"); // 이동 실패

        // 이동 실행
        addPieceAt(target, movingPiece);
        setBlank(start);
        System.out.println(movingPiece.getRepresentation() + start + " moved to " + target);
    }

    private List<Square> getAvailableSquares(Piece piece, Square start) {
        List<Square> squares = new ArrayList<>();

        if (piece.getType() == Piece.Type.PAWN) checkPawnMove(piece, start, squares);
        else {
            piece.getDirection().forEach(D -> {
                checkCanMove(piece, start, squares, D, 0);
            });
        }
        return squares;
    }

    private void checkPawnMove(Piece piece, Square start, List<Square> squares){ // 중복 로직 수정 필요
        if ((start.rankIndex() == 6 && piece.getColor() == Color.WHITE) || (start.rankIndex() == 1 && piece.getColor() == Color.BLACK))
            checkCanPawnMove(piece, start, squares, piece.getDirection().get(0), -1);
        else checkCanPawnMove(piece, start, squares, piece.getDirection().get(0), 0);

        Square target;
        try {
            target = getSquare(start, piece.getDirection().get(1));
            if (findPiece(target).getColor() != piece.getColor() && findPiece(target).getColor() != Color.NOCOLOR) squares.add(target);
        }catch (IllegalArgumentException outRange){
        }
        try {
            target = getSquare(start, piece.getDirection().get(2));
            if (findPiece(target).getColor() != piece.getColor() && findPiece(target).getColor() != Color.NOCOLOR) squares.add(target);
        }catch (IllegalArgumentException outRange){}
    }

    private void checkCanMove(Piece piece, Square start, List<Square> squares, Direction D, int count) {
        if (count == piece.canMove) return;

        Square target;
        try {
            target = getSquare(start, D); // inRange 검증
        } catch (IllegalArgumentException outRange) {
            return;
        }

        Piece pieceAtTarget = findPiece(target);
        if (pieceAtTarget.getType() == Piece.Type.BLANK) { // 빈칸이라면 이동 가능 , 다음 확인 위해 재귀 호출
            squares.add(target);
            checkCanMove(piece, target, squares, D, count + 1);
        }

        // 다른 색이면 거기까지 추가 , 같은 색이면 추가 안하고 그만
        if (pieceAtTarget.getColor() != piece.getColor()) squares.add(target);
    }

    private void checkCanPawnMove(Piece piece, Square start, List<Square> squares, Direction D, int count) {
        if (count == piece.canMove) return;

        Square target;
        try {
            target = getSquare(start, D); // inRange 검증
        } catch (IllegalArgumentException outRange) {
            return;
        }

        Piece pieceAtTarget = findPiece(target);
        if (pieceAtTarget.getType() == Piece.Type.BLANK) { // 빈칸이라면 이동 가능 , 다음 확인 위해 재귀 호출
            squares.add(target);
            checkCanPawnMove(piece, target, squares, D, count + 1);
        }
    }


    private Piece findPiece(Square square) throws IndexOutOfBoundsException {
        return board.get(square.rankIndex()).getPiece(square.fileIndex());
    }

    void addPieceAt(Square square, Piece piece) {
        board.get(square.rankIndex()).setPiece(square.fileIndex(), piece);
    }

    private void setBlank(Square square) {
        addPieceAt(square, PieceFactory.createBlank());
    }

    public double getScore(Color color) {
        return Arrays.stream(Piece.Type.values())
                .mapToDouble(type -> countPiece(color, type) * type.getScore())
                .sum()
                - countOverPawn(color) * Piece.Type.PAWN.getScore() / 2;
    }

    private int countOverPawn(Color color) {
        int overPawn = 0;
        for (int file = 1; file <= MAX_FILE; file++) {
            int cnt = 0;
            for (int rank = 1; rank <= MAX_RANK; rank++) {
                Piece piece = findPiece(getSquare(rank, file));
                if (piece.getType() == Piece.Type.PAWN && piece.getColor() == color) {
                    cnt++;
                }
            }
            overPawn += cnt > 1 ? cnt : 0; // 점수 빼야 하는 기물 수
        }
        return overPawn;
    }

    private int countPiece(Color color, Piece.Type type) {
        return (int) board.stream().mapToLong(rank -> rank.stream()
                .filter(p -> p.getColor() == color && p.getType().equals(type))
                .count()).sum();
    }

    public List<Rank> getBoard() {
        return Collections.unmodifiableList(board);
    }
}
