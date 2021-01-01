class Program22 {
    enum WashChoice{cotton,wool,linen,synthetic}
    public static void main(String[] args){
        WashChoice wash = WashChoice.cotton;
        int clothes = 3;

        switch(clothes){
            case 1:
                System.out.println("Washing shirts.");
                wash = WashChoice.cotton;
                break;
            case 2:
                System.out.println("Washing sweaters.");
                wash = WashChoice.wool;
                break;
            case 3:
                System.out.println("Washing socks.");
                wash = WashChoice.wool;
                break;
            case 4:
                System.out.println("Washing sheets");
                wash = WashChoice.linen;
                break;
            case 5:
                System.out.println("Washing pants.");
                wash = WashChoice.synthetic;
                break;
            default:
                System.out.println("Unknown washing - default synthetic");
                wash = WashChoice.synthetic;
                break;
        }
    }   
}
