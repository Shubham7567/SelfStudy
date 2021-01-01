class Program15 {
    public static void main(String[] args){
        int fishCount = 20;
        //Number of fishes in pond
        int fishLength = 10; //Average fish length
        int lengthPerSqFit = 2; //fish length per square foot of surface
        double radius = 0.0; //Pond radius in feet
        int feet = 0;
        int inches = 0;
        //Pond radius whole feet
        //and whole inches
        double pondArea = (double)(fishCount * fishLength)/lengthPerSqFit;//to calculate pond area
        radius = Math.sqrt(pondArea/Math.PI);//to calcualte radius of pond
        feet = (int)Math.floor(radius);//get feet

        inches = (int)Math.round(12.0 * (radius - feet));//get inches
        System.out.println("To hold " + fishCount + " fishes averaging " + fishLength + " inches long, you need a pond with an area of \n"+ pondArea + " squarefeet.");
        System.out.println("The radius of pond with area " + pondArea + " squarefeet is \n" + feet + " feet and " + inches + "inches.");
    }    
}
