package entity.Comments;

import java.util.List;

public class Comments {
    private final int comment_id;
    private final int id;
    private final String text;
    private final int article_id;
    private final List<Comments_likes> likes;
    private final List<Comments_tags> tag;

    public Comments(int comment_id, int id, String text, int article_id, List<Comments_likes> likes, List<Comments_tags> tag)
    {
        this.comment_id = comment_id;
        this.id = id;
        this.text = text;
        this.article_id = article_id;
        this.likes = likes;
        this.tag = tag;
    }

    @Override
    public String toString()
    {
        return "Comments{" +
                "comment_id="+comment_id+
                ", id="+id+
                ", text='"+text+
                ", article_id="+article_id+'\''+
                ", likes="+likes.size()+
                ", tag="+tag.toString()+
                '}';
    }

    public int getComment_id()
    {
        return comment_id;
    }

    public int getId()
    {
        return id;
    }

    public String getText()
    {
        return text;
    }

    public int getArticle_id()
    {
        return article_id;
    }

    public List<Comments_likes> getLikes()
    {
        return likes;
    }

    public List<Comments_tags> getTag()
    {
        return tag;
    }
}
