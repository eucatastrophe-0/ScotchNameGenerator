import java.util.Scanner;

public class ScotchNameGenerator {

    public static void main(String[] args) {
        
        //11-10-20: minor error - possible to get double white space, i.e. "St.  Ich"
        //3-29-23: fixed double white space error
        
        //TO DO:
        //  bottling strength, cask info (finishes, single cask, etc), nosing + tasting notes
        
        Scanner scan = new Scanner(System.in);
        
        int numBottles = 100;
        int age;
        int dValue = 8;
        int numDice = 3;
        int modDice = 2;
        int modValue = 2;
        
        //System.out.print("How many bottles to generate? ");
        //numBottles = scan.nextInt();
        //System.out.println("");
        
        for (int i = 0; i < numBottles; i++) {
            age = diceRoll(numDice, dValue);
            age -= age % diceRoll(modDice, modValue);
            if (age < 10) {
                System.out.println(scotchName() + " NAS");
            }
            else {
                System.out.println(scotchName() + " " + age + "yo");
            }
        }
    }
    
    public static String scotchBottling() {
        String bottling = "";
        String caskType = "";
        String bottler = "";
        double ABV;
        
        
        
        return bottling;
    }
    
    public static String scotchName() {
        String scotchName;
        String firstLetter;
        String sub1, subStart, subEnd;
        int middleNum;
        int length;
        int temp;
        
        //strings contain syllables to choose from
        //three groups: start, middle, end
        
        String[] start = {"glen", "glen ", "loch", "dun", "auch", "ben", "aber", "glas",
                "edin", "tyr", "ail", "dal", "mac", "kin", "knock", "St. ", "spring", "rose", "craig", "cap"};
        String[] middle = {" ", "liv", "ri", "ro", "ra", "na", "ni", "al", "il", "el",
                "och", "is", "ga", "vul", "cho", "roth", "mor", "fid", "far", "en", "ful", "or"};
        String[] end = {"aig", "et", "aich", "ach", "ie", "more", "eg", "ich", "och", "wood", "mill",
                "clyde", "lan", "lin", "bank", "bhain", "hain", "duff"};
        
        //pick random start syllable
        scotchName = start[(int) (Math.random() * start.length)];
        
        //pick random # of middle syllables, 0-3
        middleNum = (int) (Math.random() * 4);
        
        //for loop appends [middleNum] random middle syllables
        for (int i = 1; i < (middleNum +1); i++) {
            temp = (int) (Math.random() * middle.length);
            if (!(temp==0 && " ".equals(scotchName.substring(scotchName.length()-1)))) {
                scotchName += middle[temp];
            }
        }
        
        //append end syllable
        scotchName += end[(int) (Math.random() * end.length)];
        
        //Let's capitalize letters where needed, using substrings
        //First, capitalize the first letter
        
        length = scotchName.length();
        firstLetter = scotchName.substring(0,1).toUpperCase();
        scotchName = firstLetter + scotchName.substring(1, length);
        
        //Next, use for loop + substrings to cycle though to find any white spaces
        //and capitalize the next letter
        
        for (int i = 0; i < length - 1; i++) {
            sub1 = scotchName.substring(i, i+1);
            if (sub1.equals(" ")) {
                subStart = scotchName.substring(0, i+1);
                sub1 = scotchName.substring(i+1, i+2).toUpperCase();
                subEnd = scotchName.substring(i+2, length);
                scotchName = subStart + sub1 + subEnd;
            }
        }
        
        //return scotch name
        
        return scotchName;
    }
    
    public static int diceRoll(int numDice, int dValue) {
        //this method simulates an arbitrary dice roll in xdy format
        //where x is the # of dice and and y is the # of faces per die
        //  i.e. 2d6 = rolling two 6 sided dice
        //       1d20 = one 20 sided die
        
        int value = 0;
        
        for (int j = 0; j < numDice; j++) {
                value += (int) (Math.random() * dValue) + 1;
            }
            
        return value;
    }
}
