package t1908m.assignment.java1.controller;

import t1908m.assignment.java1.entity.Article;

public interface ArticleController {
    // yêu cầu ng dùng nhập vào thông tin article,
    Article createArticle();
    // Hiển thị danh sách theo format.
    void printListArticle(java.util.ArrayList<Article> listArticle);

}
