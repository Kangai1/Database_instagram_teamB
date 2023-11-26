package entity.Comments;

public class Comments_tags {
    private final int comment_id;
    private final String tag;
    private final int id;

    public Comments_tags(int comment_id, String tag, int id)
    {
        this.comment_id = comment_id;
        this.tag = tag;
        this.id = id;
    }

    public int getComment_id()
    {
        return comment_id;
    }

    public int getId()
    {
        return id;
    }

    public String getTag()
    {
        return tag;
    }

    @Override
    public String toString()
    {
        return "Comments_tags{"+
                "comment_id="+comment_id+
                ", tag="+tag+
                ", id='"+id+'\''+
                '}';
    }
}
