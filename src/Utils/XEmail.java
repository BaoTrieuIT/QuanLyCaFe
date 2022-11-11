
package Utils;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
*/

import java.util.regex.*;



public class XEmail {
        public static void parseEmail (String str) throws Exception{
            String mau = "\\w+@\\w+(\\.\\w+){1,2}";
            Pattern pattern = Pattern.compile(mau);
            Matcher matcher = pattern.matcher(str);
            if(matcher.matches() == false){
                throw new Exception();
            }
        }

    
}
