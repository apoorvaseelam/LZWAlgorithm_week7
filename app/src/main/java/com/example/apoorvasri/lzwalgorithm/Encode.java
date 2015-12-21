package com.example.apoorvasri.lzwalgorithm;

/**
 * Created by ApoorvaSri on 12/14/2015.
 */
import java.util.LinkedList;

public class Encode
{
    private LinkedList<String> cursorSequence= null;
    private LinkedList<Integer> code =null;
    private LinkedList<String> bits =null;

    public Encode()
    {
        cursorSequence = new LinkedList<String>();
        code = new LinkedList<Integer>();
        bits = new LinkedList<String>();
        
        String initialString = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < initialString.length(); i++)
        {
            this.cursorSequence.add(initialString.charAt(i) + "");
            this.code.add(i);
            String theBits ;
            theBits = Integer.toBinaryString(i);
            theBits = new String(new char[(5 - theBits.length())]).replace("\0", "0") + theBits;
            this.bits.add(theBits);
        }
    }

    public String output(String str)
    {
        int index = 0;
        String current = getCurrent(str, index);
        char nextChar =str.charAt(index + current.length());
        String extString;

        String result = "";

        while (nextChar != '#')
        {
            String theBits ;
            theBits = getBits(current);
            result += theBits;
            extString = current + nextChar;
            this.cursorSequence.add(extString);
            this.code.add(code.size());
            this.bits.add(Integer.toBinaryString(bits.size()));
            index = index + current.length();
            current = getCurrent(str, index);
            nextChar = str.charAt(index + current.length());
        }
        result += getBits(current) + getBits("#");
        return result;
    }

    //find next longest string that is in curSequence
    private String getCurrent(String str, int index)
    {
        String curString = str.charAt(index) + "";
        String extString;
        boolean check = true;
        while (check)
        {
            boolean isIn = false;
            extString = curString + str.charAt(index + 1);
            for (int i = 0; i < this.cursorSequence.size(); i++)
            {
                if (extString.equals(this.cursorSequence.get(i)))
                {
                    isIn = true;
                }
            }
            if (isIn)
            {
                check = true;
                curString = extString;
                index++;
            }
            else
            {
                check = false;
            }
        }
        return  curString;
    }

    private String getBits(String s)
    {
        for (int i = 0; i < this.cursorSequence.size(); i++)
        {
            if (s.equals(this.cursorSequence.get(i)))
            {
                String theBits = this.bits.get(i);
                if (code.size() >= 33)
                {
                    theBits = new String(new char[(6 - theBits.length())]).replace("\0", "0") + theBits;
                }
                return theBits;
            }
        }
        return "not found, please try again";
    }
}