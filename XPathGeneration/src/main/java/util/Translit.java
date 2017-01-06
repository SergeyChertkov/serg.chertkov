package util;

import java.util.ArrayList;
import java.util.List;

public class Translit {
    private static List<Character> non_parser;
    private static int limit = 30;
    static {
        char [] non_parser_char = {'A','B','C','D','E','F','G','H','I',
                'J','K','L','M','N','O','P','Q','R','S','T','U','F','V','W',
                'X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
        non_parser = new ArrayList<Character>();
        for (char character:
             non_parser_char) {
            non_parser.add(character);
        }
    }

    public static String cyr2lat(char ch){
        if(non_parser.contains(ch))
            return String.valueOf(ch);
        switch (ch){
            case 'А': return "A";
            case 'Б': return "B";
            case 'В': return "V";
            case 'Г': return "G";
            case 'Д': return "D";
            case 'Е': return "E";
            case 'Ё': return "E";
            case 'Ж': return "ZH";
            case 'З': return "Z";
            case 'И': return "I";
            case 'Й': return "Y";
            case 'К': return "K";
            case 'Л': return "L";
            case 'М': return "M";
            case 'Н': return "N";
            case 'О': return "O";
            case 'П': return "P";
            case 'Р': return "R";
            case 'С': return "S";
            case 'Т': return "T";
            case 'У': return "U";
            case 'Ф': return "F";
            case 'Х': return "H";
            case 'Ц': return "C";
            case 'Ч': return "CH";
            case 'Ш': return "SH";
            case 'Щ': return "SCH";
            case 'Ъ': return "";
            case 'Ы': return "Y";
            case 'Ь': return "";
            case 'Э': return "E";
            case 'Ю': return "JU";
            case 'Я': return "JA";

            default: return " ";
        }
    }

    public static String cyr2lat(String s){
        if (s == null || s.length() < 1)
            return null;
        StringBuilder sb = new StringBuilder(s.length()*2);
        for(char ch: s.toCharArray()){
            sb.append(cyr2lat(ch));
        }
        return sb.toString();
    }

    public static String generateName (String s){
        if(s==null || s.length() < 3)
            return null;
        String str = cyr2lat(s.toUpperCase());
        while(str.contains("  "))
            str = str.replaceAll("  "," ");
        if(str.length() < 3)
            return null;
        while(str.lastIndexOf(" ")==str.length()-1)
            str = str.substring(0,str.length()-1);
        while(str.indexOf(" ")==0)
            str = str.substring(1,str.length());
        if(str.length()>limit){
            str = str.substring(0,limit);
            if(str.lastIndexOf(' ')>0)
                str = str.substring(0,str.lastIndexOf(' '));
        }
        return str;
    }
}
