package repository.Comments;

import entity.Comments.Comments_tags;
import jdbc.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentsTagsRepository {
    List<Comments_tags> findByCommentId(int keyId)
    {
        Connection con = ConnectionManager.getCon();
        Statement stmt;
        List<Comments_tags> rst = new ArrayList<>();
        try
        {
            stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from comment_tags where comment_id=" + keyId);
            while (resultSet.next()) 
            {
                int comment_id = resultSet.getInt(1);
                String tag = resultSet.getString(2);
                int id = resultSet.getInt(3);
                rst.add(new Comments_tags(comment_id, tag, id));
            }
            return rst;
        } catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
