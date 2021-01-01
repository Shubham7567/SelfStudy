import java.lang.Math;
import java.util.Scanner;


interface FindParameter
{
    double parameter(double var1,double var2);
}

class Perimiter 
{
    public static void main(String[] args){

        FindParameter circle = (r,pi) -> {
            return (double)(2*pi*r);
        };
        FindParameter rectangle = (height,width) -> {
            return (double)(height+height+width+width);
        };
        FindParameter ellipse = (a,b) -> {
            return (double)(2*3.14*Math.sqrt(((a*a)+(b*b))/2));
        };

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Radius of circle:");
        double circleRadius=sc.nextDouble();

        System.out.println("Enter value of length: ");
        double rectangleLength=sc.nextDouble();
        System.out.println("Enter value of width: ");
        double rectangleWidth=sc.nextDouble();

        System.out.println(circle.parameter(circleRadius, (double)3.14));
        System.out.println(rectangle.parameter(rectangleLength,rectangleWidth));
        System.out.println("Enter value of Major x: ");
        double ellipsMajorX=sc.nextDouble();
        System.out.println("Enter value of Minur y: ");
        double ellipsMinorY=sc.nextDouble();

        System.out.println(ellipse.parameter( ellipsMajorX, ellipsMinorY));
    }
}