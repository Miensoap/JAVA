package application.db.H2DB;

import application.db.interfaces.ArticleDB;
import application.model.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2ArticleDB extends H2DataBase implements ArticleDB {
    private final Connection connection;

    public H2ArticleDB() throws SQLException {
        this.connection = super.connection;
    }

    @Override
    public void addArticle(Article article) {
        String createArticleQuery = "INSERT INTO Article (content , userName , filePath, articleIndex) VALUES (? ,?, ?, ?);";

        try (PreparedStatement query = connection.prepareStatement(createArticleQuery)) {
            query.setString(1, article.content());
            query.setString(2, article.writer());
            query.setString(3, article.filePath());
            query.setInt(4, article.index());
            query.executeUpdate();

            logInfo("Insert Article : " + article.index());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Article getArticle(int index) {
        String getArticleQuery = "SELECT * FROM Article WHERE articleindex =  ? ;";

        try (PreparedStatement query = connection.prepareStatement(getArticleQuery)) {
            query.setInt(1, index);
            try (ResultSet resultSet = query.executeQuery()){
                if (resultSet.next()) {
                    return convertRowToArticle(resultSet);
                }
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Article convertRowToArticle(ResultSet resultSet) throws SQLException {
        String content = resultSet.getString(1);
        String writer = resultSet.getString(2);
        String filePath = resultSet.getString(3);
        int index = Integer.parseInt(resultSet.getString(4));
        return new Article(content, filePath, writer, index);
    }

    @Override
    public int getSize() {
        String getSizeQuery = "SELECT COUNT(*) FROM Article;";

        try (PreparedStatement query =connection.prepareStatement(getSizeQuery)) {
            try(ResultSet resultSet = query.executeQuery()) {

                if (!resultSet.next()) return 0;
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}