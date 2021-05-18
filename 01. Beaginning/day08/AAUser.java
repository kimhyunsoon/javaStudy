class AAUser{
    public static void main(String[] args) {
        Grandfather g = new Grandfather("할아버지");
        g.showinfo();
        g.earn();
        father f = new father("개발자",45,500);
        f.showinfo();
        f.earn();
        Child c = new Child("학생",15);
        c.showinfo();

    }

}