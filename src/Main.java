import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("Первая задача");
        System.out.println(Bessi(10,7,"hello my name is Bessie and this is my essay")); //1 task
        System.out.println("");
        System.out.println("Вторая задача");
        System.out.println(split("((()))(())()()(()())"));//2 task
        System.out.println("");
        System.out.println("Третья задача");
        System.out.println(toSnakelCase("helloEdabit")); //3 task
        System.out.println(toCameCase("hello_edabit")); //3 task
        System.out.println("");
        System.out.println("Четвертая задача");
        System.out.printf("$" + "%.2f", overTime(new double[]{13.25, 15, 30, 1.5})); //4 task
        System.out.println("");
        System.out.println("");
        System.out.println("Пятая задача");
        System.out.println(BMI("154 pounds", "2 meters"));//5 task
        System.out.println("");
        System.out.println("Шестая задача");
        System.out.println(bugger(999));//6 task
        System.out.println("");
        System.out.println("Седьмая задача");
        System.out.println(toStarShorthand("77777geff"));//7 task
        System.out.println("");
        System.out.println("Восьмая задача");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));//8 task
        System.out.println("");
        System.out.println("Девятая задача");
        System.out.println(trouble(451999277, 41177722899L));//9 task
        System.out.println("");
        System.out.println("Десятая задача");
        System.out.println(countUniqueCharacters("$AA$BBCATT$C$$B$", '$'));//10 task
    }
    //1 задача
    public static boolean doesRhyme(String line, String line2) {
        String s;
        String s2;
        int sum=0;
        int sum2=0;
        ArrayList<Character> arrayList=new ArrayList<>();
        ArrayList<Character> arrayList2=new ArrayList<>();
        String[] words = line.split(" ");
        String[] words2 = line2.split(" ");
        s=words[words.length-1];
        s2=words2[words2.length-1];
        s=s.toLowerCase(Locale.ENGLISH);
        s2=s2.toLowerCase(Locale.ENGLISH);
        char characters[]=s.toCharArray();
        char characters2[]=s2.toCharArray();
        for(int l=0;l<characters.length;l++){
            if(characters[l]=='a'||characters[l]=='e'||characters[l]=='i'||characters[l]=='o'||characters[l]=='u'||characters[l]=='y'){
                arrayList.add(characters[l]);
                sum++;
            }
        }
        for(int l=0;l<characters2.length;l++){
            if(characters2[l]=='a'||characters2[l]=='e'||characters2[l]=='i'||characters2[l]=='o'||characters2[l]=='u'||characters2[l]=='y'){
                arrayList2.add(characters2[l]);
                sum2++;
            }
        }
        char cha[]=new char[arrayList.size()];
        char cha2[]=new char[arrayList2.size()];
        if(sum!=sum2){
            return false;
        }
        for(int d=0;d<arrayList.size();d++){
            cha[d]=arrayList.get(d);
        }
        for(int d=0;d<arrayList2.size();d++){
            cha2[d]=arrayList2.get(d);
        }

        return Arrays.equals(cha,cha2);
    }
    public static ArrayList<String> split(String line) {
        int left = 0;
        int right = 0;
        String s = "";
        char[] strToArray = line.toCharArray();
        ArrayList<Character> array = new ArrayList<>();
        for (char c : strToArray) {
            array.add(c);
        }
        array.add(' ');
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < line.length()+1; i++) {
            if(left==right&&left!=0){
                arrayList.add(s);
                left=0;
                right=0;
                s="";
                i--;
            }
            else{
                if (array.get(0) == '(') {
                    left++;
                    s += array.get(0);
                    array.remove(0);
                } else if (array.get(0) == ')') {
                    right++;
                    s += array.get(0);
                    array.remove(0);
                }
            }

        }
        return arrayList;
    }
    public static int countUniqueCharacters(String s,char c) {
        int num=0;
        int a=0;
        String str="";
        ArrayList<String> arrayList=new ArrayList<>();
        char characters2[]=s.toCharArray();
        for(int d=0;d<characters2.length;d++) {
            while(a<2&&d!=characters2.length) {
                if (characters2[d] == c&&a==0) {
                    a++;
                    str="";

                } else if(characters2[d] == c&&a==1){
                    arrayList.add(str);
                    a--;
                    // a--;
                    str="";
                }
                else{
                    str += characters2[d];
                }
                d++;
            }
        }
        for (String value : arrayList) {
            str += value;
        }

        char characters[] = str.toCharArray();
        int l = str.length();
        for (int i = 0; i < characters.length; i++) {
            if (i != str.indexOf(characters[i])) {
                l--;
            }
        }
        if(num<l){
            num=l;
        }
        return num;
    }
    public static int bugger(int num){
        int l = 0;
        int temp;
        while (num > 9) {
            temp = 1;
            while (num > 0) {
                temp *= num % 10;
                num /= 10;
            }
            num = temp;
            l++;
        }
        return l;
    }
    public static String Bessi(int N,int K,String line){
        String[] word;
        int[] l = new int[N];
        word = line.split(" " );
        for(int i =0; i < N; i++) {
            l[i] = word[i].length();
        }
        String result = "";
        int temp = 0;
        for(int i = 0; i < N; i++){
            if(l[i] + temp > K){
                result = result.substring(0,result.length()-1);
                result += "\n" + word[i] + " ";
                temp = l[i];
            }
            else if(l[i] + temp <= K){
                temp+= l[i];
                result += word[i] + " ";
            }

        }
        return result.substring(0,result.length()-1);
    }
    public static boolean trouble(long num1, long num2) {
        int lnum1 = 0;
        int lnum2 = 0;
        boolean result = false;
        String s = String.valueOf(num1);
        char[] strToArray1 = s.toCharArray();
        s = String.valueOf(num2);
        char[] strToArray2 = s.toCharArray();
        for (int i = 1; i < strToArray1.length - 1; i++) {
            if (lnum1 > 2) {
                break;
            } else if (strToArray1[i] == strToArray1[i - 1]) {
                lnum1 += 2;
            } else if (strToArray1[i] == strToArray1[i + 1] || strToArray1[i] == strToArray1[i - 1]) {
                lnum1++;
            }
        }
        for (int i = 1; i < strToArray2.length - 1; i++) {
            if (lnum2 > 1) {
                break;
            } else if (strToArray2[i] == strToArray2[i - 1]) {
                lnum2 += 2;
            } else if (strToArray2[i] == strToArray2[i + 1]) {
                lnum2++;
            }
        }
        if (lnum1 >= 3 && lnum2 >= 2) {
            result = true;
        }
        return result;
    }
    public static String toStarShorthand(String line) {
        int sell = 0;
        String s = "";
        char[] strToArray2 = line.toCharArray();
        ;
        char[] strToArray = new char[strToArray2.length + 1];
        for (int r = 0; r < strToArray2.length; r++) {
            strToArray[r] = strToArray2[r];
        }
        strToArray[strToArray.length - 1] = ' ';
        ArrayList<String> array1 = new ArrayList<>();
        for (int i = 0; i < strToArray.length - 1; i++) {
            if (strToArray[i] == strToArray[i + 1]) {
                sell++;
            } else {
                if (sell > 0) {
                    sell++;
                    String set = String.valueOf(strToArray[i]);
                    array1.add(set);
                    array1.add("*");
                    set = String.valueOf(sell);
                    array1.add(set);
                } else {
                    String set = String.valueOf(strToArray[i]);
                    array1.add(set);
                }
                sell = 0;
            }
        }
        for (int i = 0; i < array1.size(); i++) {
            s = s + array1.get(i);
        }
        return s;
    }
    public static String BMI(String line1, String line2) {
        System.out.println();
        String ove;
        int i = 0;
        double puds = 1;
        double duim = 1;
        String s = "";
        char[] strToArray1 = line1.toCharArray();
        char[] strToArray2 = line2.toCharArray();
        ArrayList<Character> array1 = new ArrayList<>();
        ArrayList<Character> array2 = new ArrayList<>();
        for (int l = 0; l < strToArray1.length; l++) {
            if ((strToArray1[i] >= '0') && (strToArray1[i] <= '9')) {
                array1.add(strToArray1[i]);
                i++;
            } else if (strToArray1[i] == 'p') {
                puds = 0.453;

            } else {
                i++;
            }
        }
        for (int ii = 0; ii <= array1.size() - 1; ii++) {
            s = s + array1.get(ii);
        }
        double kil = Double.parseDouble(s);
        kil = Math.round(kil * puds);
        i = 0;
        s = "";
        for (int l = 0; l < strToArray2.length; l++) {
            if ((strToArray2[i] >= '0') && (strToArray2[i] <= '9')) {
                array2.add(strToArray2[i]);
                i++;
            } else if (strToArray2[i] == 'i') {
                duim = 0.0254;

            } else {
                i++;
            }
        }
        for (int ii = 0; ii <= array2.size() - 1; ii++) {
            s = s + array2.get(ii);
        }
        double met = Double.parseDouble(s);
        met = met * duim;
        if ((kil / (Math.pow(met, 2))) > 25) {
            ove = " Overweight";
        } else if ((kil / (Math.pow(met, 2))) < 18.5) {
            ove = " Underweight";
        } else {
            ove = " Normal weight";
        }

        String result = String.valueOf(kil / (Math.pow(met, 2)));
        return result + ove;
    }
    public static String toCameCase(String line) {
        int i = 0;
        char[] strToArray = line.toCharArray();
        ArrayList<Character> array = new ArrayList<>();
        for (int l = 0; l < strToArray.length - 1; l++) {
            if ((strToArray[i] >= 'a') && (strToArray[i] <= 'z')) {
                array.add(strToArray[i]);
                i++;
            } else if (strToArray[i] == '_') {
                i++;
                String c = String.valueOf(strToArray[i]).toUpperCase();
                char a = c.charAt(0);
                array.add(a);
                i++;
            }
        }
        String line2 = "";
        for (int ii = 0; ii < array.size(); ii++) {
            line2 = line2 + array.get(ii);
        }
        return line2;
    }
    public static String toSnakelCase(String line) {
        int i = 0;
        char[] strToArray = line.toCharArray();
        ArrayList<Character> array = new ArrayList<>();
        for (int l = 0; l < strToArray.length; l++) {
            if ((strToArray[i] >= 'a') && (strToArray[i] <= 'z')) {
                array.add(strToArray[i]);
                i++;
            } else if ((strToArray[i] >= 'A') && (strToArray[i] <= 'Z')) {
                array.add('_');

                String c = String.valueOf(strToArray[i]).toLowerCase();
                char a = c.charAt(0);
                array.add(a);
                i++;
            }
        }
        String line2 = "";
        for (Character character : array) {
            line2 += character;
        }
        return line2;
    }
    public static double overTime(double[] arr) {
        double cash = 0;
        double cash2 = 0;
        if (arr[1] <= 17) {
            cash = (arr[1] - arr[0]) * arr[2];
        } else if (arr[1] > 17 && arr[1] < 25) {
            cash = (17 - arr[0]) * arr[2];
            cash2 = (arr[1] - 17) * arr[2] * arr[3];
        }
        return cash + cash2;
    }
}