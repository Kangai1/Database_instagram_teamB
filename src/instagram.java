import jdbc.ConnectionManager;
import service.ArticleService;

import java.sql.SQLException;

public class instagram
{
    private final ArticleService articleService = new ArticleService();
    public static void main(String[] args) throws SQLException
    {
        ConnectionManager.getConnection();
    }
}
