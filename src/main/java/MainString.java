public class MainString {

    public static void main(String[] args) {
        String minuscule = "ceci est une chaine en minuscule";
        String majuscule = toMajuscule(minuscule);
        System.out.println(majuscule);

        majuscule = majuscule.replaceAll("MINUSCULE", "MAJUSCULE");
        System.out.println(majuscule);

        int count = countChar(majuscule, 'A');
        System.out.println(count);

        majuscule = replaceAllBy4(majuscule);
        System.out.println(majuscule);

        majuscule = remove5to10(majuscule);
        System.out.println(majuscule);

        int i = 42;
        String string = String.valueOf(i);
        int integer = Integer.parseInt(string);
        System.out.println(integer);
    }

    private static String remove5to10(String input) {
        if(input.length()<5){
            return input;
        }

        String result = "";

        if(input.length()>5){
            result = input.substring(0,5);
        }
        if(input.length()>10){
            result+= input.substring(5,10);
        }
        return result;
    }

    private static String replaceAllBy4(String input) {
        return input.replaceAll("A", "4");
    }

    private static int countChar(String input, char charToCount) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == charToCount){
                count++;
            }
        }
        return count;
    }

    private static String toMajuscule(String input) {
        return input.toUpperCase();
    }

}
