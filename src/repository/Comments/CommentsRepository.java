package repository.Comments;

import entity.Comments.Comments;
import entity.Comments.Comments_likes;
import entity.Comments.Comments_tags;
import jdbc.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentsRepository {
    private final CommentsLikesRepository commentsLikesRepository = new CommentsLikesRepository();
    private final CommentsTagsRepository commentsTagsRepository = new CommentsTagsRepository();
    public List<Comments> findByArticleId(int keyId)
    {
        List<Comments_likes> likes = commentsLikesRepository.findByCommentId(keyId);
        List<Comments_tags> tags = commentsTagsRepository.findByCommentId(keyId);
        Connection con = ConnectionManager.getCon();
        Statement stmt;
        
        try
        {
            stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from comment where article_id=" + keyId);
            List<Comments> rst = new ArrayList<>();
            while(resultSet.next())
            {
                int comment_id = resultSet.getInt(1);
                int id = resultSet.getInt(2);
                String text = resultSet.getString(3);
                int article_id = resultSet.getInt(4);
                rst.add(new Comments(comment_id, id, text, article_id, likes, tags));
            }
            return rst;
        } catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
