package t1908m.assignment.java1.controller;

import t1908m.assignment.java1.entity.Article;

public class ArticleControllerImplement implements ArticleController {
    private java.util.Scanner scanner = new java.util.Scanner(System.in);

    @Override
    public Article createArticle() {
        Article article = new Article();
        System.out.println(String.format("\nMORE ARTICLE\n"));
        System.out.print("Enter code article: ");
        article.setCode(scanner.nextLine());
        System.out.print("Enter the article title: ");
        article.setTitle(scanner.nextLine());
        System.out.print("Enter a description of the article: ");
        article.setDescription(scanner.nextLine());
        System.out.print("Enter avata article: ");
        article.setAvata(scanner.nextLine());
        System.out.println("Enter the article content: ");
        article.setContent(scanner.nextLine());
        System.out.print("Enter the name of the author article: ");
        article.setAuthor(scanner.nextLine());
        System.out.print("Enter day writes: ");
        article.setDayWrites(scanner.nextLine());
        return article;
    }

    @Override
    public void printListArticle(java.util.ArrayList<Article> listArticle) {
        System.out.println(String.format("\nLIST OF YOUR ARTICLE:"));
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------");
        for (int j = 0; j < listArticle.size(); j++) {
            Article article = (Article) listArticle.get(j);
            System.out.println(String.format("\nPOSTS %s: %s", j + 1, article.getTitle()));
            System.out.println(String.format("Code: %s  ||  Day writes: %s", article.getCode(), article.getDayWrites()));
            System.out.println(String.format("Avata: %s", article.getAvata()));
            System.out.println(String.format("Description: %s", article.getDescription()));
            System.out.println(String.format("Content:\n%s", article.getContent()));
            System.out.println(String.format("Author: %s", article.getAuthor()));
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }

}
