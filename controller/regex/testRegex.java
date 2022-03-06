package regex;

public class testRegex {
    public static Regex tool = new Regex();
    public static String[] exampleId = {"a1","p2","pf","f2","123","p120"};
    public static String[] exampleName = {"a1","phuongAnh","pf","Nguyen Van A","@long","anh+ "};
    public static String[] examplePhone = {"a1","phuongAnh","pf","7 8 9","@68","1234","091238432 1","0912323214","123241521"};
    public static String[] exampleMail = {"1@2.3","a@b.c","a3@abc.as","linhmail.com","linh@mail.com","1234@mail","123@123.123","a@a.a","linh@gmail com"};


    public static void main(String[] args) {
        for (String e: exampleId
             ) {
            displayValid(e);
            System.out.print(tool.isValidId(e)+"\n");
        }
        for (String e: exampleName
             ) {
            displayValid(e);
            System.out.print(tool.isValidName(e)+"\n");
        }
        for (String e: examplePhone
             ) {
            displayValid(e);
            System.out.print(tool.isValidPhone(e)+"\n");
        }
        for (String e: exampleMail
             ) {
            displayValid(e);
            System.out.print(tool.isValidMail(e)+"\n");
        }
    }
    public static void displayValid(String string){
        System.out.print("\n"+ string + " is valid? ");
    }
}
