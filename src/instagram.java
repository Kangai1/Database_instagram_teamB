import entity.Comments.Comments;
import jdbc.ConnectionManager;
import repository.Comments.CommentsRepository;

import java.sql.Connection;
import java.util.List;

public class instagram
{
    public static void main(String[] args)
    {
        Connection connection = ConnectionManager.getConnection();
        CommentsRepository cRepository = new CommentsRepository();
        List<Comments> byArticleId = cRepository.findByArticleId(1);
        for (Comments col : byArticleId)
        {
            System.out.println("col = " + col.toString());
        }
    }
}