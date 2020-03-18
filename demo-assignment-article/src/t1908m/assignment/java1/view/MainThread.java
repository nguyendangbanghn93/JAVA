package t1908m.assignment.java1.view;

public class MainThread {

    public static void main(String[] args) {
        getMenu();
    }
    //Tạo menu
    public static void getMenu() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        t1908m.assignment.java1.controller.ArticleControllerImplement article = new t1908m.assignment.java1.controller.ArticleControllerImplement();
        java.util.ArrayList<t1908m.assignment.java1.entity.Article> listArticle = new java.util.ArrayList<t1908m.assignment.java1.entity.Article>();
        System.out.println(String.format("        WELCOME TO POSTS MANAGEMENT PROGRAM !!! "));
        while (true) {
            System.out.println(String.format("\n///////////////////   MENU   /////////////////////////"));
            System.out.println(String.format("//                                                  //"));
            System.out.println(String.format("//    1. MORE POST.                                 //"));
            System.out.println(String.format("//    2. SHOW LIST OF POSTS.                        //"));
            System.out.println(String.format("//    3. THE END.                                   //"));
            System.out.println(String.format("//                                                  //"));
            System.out.println(String.format("//////////////////////////////////////////////////////"));
            System.out.print(String.format("Choose: "));
            try {
                int choose = scanner.nextInt();
                if (choose > 3 || choose < 1) {
                    throw new t1908m.assignment.java1.exception.ExceptionNew("Error");
                }
                switch (choose) {
                    case 1:
                        String b = "y";
                        while (b.equalsIgnoreCase("y")) {
                            listArticle.add(article.createArticle());
                            System.out.print("Do you want to add to the article? (y / n)?\n");
                            while (true) {
                                b = scanner.nextLine();
                                if (b.equalsIgnoreCase("n") || b.equalsIgnoreCase("y")) {
                                    break;
                                } else if (!b.equalsIgnoreCase("y") && !b.equalsIgnoreCase("n")) {
                                    System.out.println("Entered incorrectly formatted, re-enter your request: ");
                                }
                            }
                        }
                        break;
                    case 2:
                        article.printListArticle(listArticle);
                        break;
                    case 3:
                        System.out.println("       THE END");
                        System.out.println("GOODBYE SEE YOU AGAIN!!!");
                        return;
                }
            } catch (Exception s) {
                System.out.println("Items you can not enter, re-enter your request (1/2/3) !!!");
                scanner.nextLine();
            }
        }
    }
}
