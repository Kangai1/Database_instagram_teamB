package repository.Comments;

import entity.Comments.Comments_likes;
import jdbc.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentsLikesRepository {
    List<Comments_likes> findByCommentId(int keyId)
    {
        Connection con = ConnectionManager.getCon();
        Statement stmt;
        List<Comments_likes> rst = new ArrayList<>();
        try
        {
            stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from comment_likes where comment_id=" + keyId);
            while (resultSet.next()) 
            {
                int comment_id = resultSet.getInt(1);
                int id = resultSet.getInt(2);
                rst.add(new Comments_likes(comment_id, id));
            }
        } catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        return rst;
    }
}
