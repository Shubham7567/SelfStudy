package lambda;

interface StringFunc{
    String func(String str);
}

public class LembdaArgumentDemo{
    static String changeStr(StringFunc sf, String a){
        return sf.func(a);
    }
    public static void main(String[] args){
        String inStr = "Lambda Expressions Expand Java";
        String outStr;
        System.out.println("Here is input string: "+ inStr);
        StringFunc reverse = (str) -> {
            String result= "";
            for(int index=str.length()-1;index >= 0; index--){
                result += str.charAt(index);
            }
            return result;
        };

        outStr = changeStr(reverse, inStr);
        System.out.println("The string reversed " + outStr);

        outStr = changeStr((str) -> str.replace(' ', '-'), inStr);
        System.out.println("The string with space replaced: "+outStr);

        outStr = changeStr((str)->{
            String result = "";
            char ch;

            for(int i=0;i < str.length(); i++){
                ch = str.charAt(i);
                if(Character.isUpperCase(ch))
                    result += Character.toLowerCase(ch);
                else
                    result += Character.toUpperCase(ch);
            }
            return result;
        }, inStr);

        System.out.println("The string is reversed case: " + outStr);
    }
}