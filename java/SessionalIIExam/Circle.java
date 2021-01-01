interface FindParameter{
    long parameter(long var1,long var2);
}

class Circle {
    public static void main(String[] args){
        FindParameter circle = (r,pi) -> {
            return (long)(2*pi*r);
        };
        FindParameter rectangle = (height,width) -> {
            return (long)(height+height+width+width);
        };
        FindParameter ellipse = (a,b) -> {
            return (long)(2*3.14*Math.sqrt(((a*a)+(b*b))/2));
        };

        System.out.println(circle.parameter((long)4, (long)3.14));
        System.out.println(rectangle.parameter((long)4, (long)3.14));
        System.out.println(ellipse.parameter((long)4, (long)3.14));
    }
}
