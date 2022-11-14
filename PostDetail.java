package entity;

public class PostDetail {
    Post post;
    int quatity;

    public PostDetail(Post post, int quatity) {
        this.post = post;
        this.quatity = quatity;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    @Override
    public String toString() {
        return "PostDetail{" +
                "post=" + post +
                ", quatity=" + quatity +
                '}';
    }
}
