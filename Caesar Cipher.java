import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

class Main {
  
  public static boolean processFile(String inputFileName, String outputFileName, String encodeDecode) throws IOException{
    int key = 5;
    caesar c = new caesar();

    try{
      BufferedReader r = new BufferedReader(new FileReader(inputFileName));
      BufferedWriter w = new BufferedWriter(new FileWriter(outputFileName));
      
      int chr = r.read();
      
    while(chr != -1){
      if(encodeDecode.equals("encode")){
        char chrs = c.CaesarEncode((char)chr, key);
        w.write(chrs);
      }
      else if(encodeDecode.equals("decode")){
        char chrs = c.CaesarDecode((char)chr, key);
        w.write(chrs);
      }
    }
    r.close();
    w.close();
    return true;
      }
    catch(FileNotFoundException e){
      System.out.println("Input/output file not found");
      return false;
    }

    /*try{
      BufferedWriter w = new BufferedWriter(new FileWriter(outputFileName));
    }
    catch(FileNotFoundException e){
      System.out.println("Output file not found");
      return false;
    }*/

    
    
  }
  
  public static void main(String[] args) {
    System.out.println("Hi, would you like to (1) encode or (2) decode a message?");
    Scanner sc = new Scanner(System.in);
    int opt = sc.nextInt();
    sc.nextLine();
    String encodeDecode;

    if(opt == 1){
      encodeDecode = "Encode";
    }
    else{
      encodeDecode = "Decode";
    }

    System.out.println("Input file name:");
    String inputFileName = sc.nextLine();
    System.out.println("Output file name:");
    String outputFileName = sc.nextLine();

    try{
    processFile(inputFileName, outputFileName, encodeDecode);
      }
    catch(IOException e){
      System.out.println("Error");
    }
    
    sc.close();
  }
}


class caesar{
/*********************************************************************
 * CaesarEncode implements the Caesar cipher encoding scheme.        *
 *                                                                   * 
 * Receive: ch, a character.                                         *
 *          key, the amount by which to rotate ch.                   *
 * Return:  The character that is key positions after ch,            *
 *          with "wrap-around" to the beginning of the sequence.     *
 *********************************************************************/

public char CaesarEncode(char ch, int key)
{
  int FIRST_UPPER = 65,
            FIRST_LOWER = 97,
            NUM_CHARS = 26;
  int chvalue = ch;
  int keyvalue = key;
  int encodechar;


  if (key <= 0 || key >= NUM_CHARS){
      System.out.println("\n CaesarEncode: key must be between 1 and 25\n");
    return Character.MIN_VALUE;
    }
  if (Character.isUpperCase(ch)){
    encodechar = (chvalue - FIRST_UPPER + keyvalue) % NUM_CHARS + FIRST_UPPER;
    return (char)encodechar;
    }
  else if (Character.isLowerCase(ch)) {
    encodechar = (chvalue - FIRST_LOWER + keyvalue) % NUM_CHARS + FIRST_LOWER;
    return (char)encodechar;
    }
  else
    return ch;
  }
/********************************************************************
 * CaesarDecode implements the Caesar cipher encoding scheme.       *
 *                                                                  * 
 * Receive: ch, a character,                                        *
 *          key, an integer.                                        *
 * Return:  The character that is key positions before ch,          *
 *          with "wrap-around" to the end of the sequence.          *
 ********************************************************************/


public char CaesarDecode(char ch, int key)
{
  int FIRST_UPPER = 65,
            FIRST_LOWER = 97,
            NUM_CHARS = 26;
  int chvalue = ch;
  int keyvalue = key;
  int decodechar;
  
  if (key <= 0 || key >= 26)
  {
     System.out.println("\n CaesarDecode: key must be between 1 and 25!\n");
     return Character.MIN_VALUE;
  }

  if (Character.isUpperCase(ch)) {
    decodechar = (ch - FIRST_UPPER + NUM_CHARS - key) % NUM_CHARS + FIRST_UPPER;
    return (char)decodechar;
    }
  else if (Character.isLowerCase(ch)) {
    decodechar = (ch - FIRST_LOWER + NUM_CHARS - key) % NUM_CHARS + FIRST_LOWER;
    return (char)decodechar;
    }
  else
    return ch;
}


  
}
