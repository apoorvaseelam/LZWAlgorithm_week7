package com.example.apoorvasri.lzwalgorithm;
/**
 * Created by ApoorvaSri on 12/14/2015.
 */
import java.util.LinkedList;

public class Decode

{
    private LinkedList<String> currentSequence = null;
    private LinkedList<Integer> code = null;
    private LinkedList<String> bits = null;

//This performs decoding

    public Decode()
    {
       currentSequence = new LinkedList<String>();
        code = new LinkedList<Integer>();
        bits = new LinkedList<String>();

        String initialString = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";//initialString

        for (int c = 0; c < initialString.length(); c++)//change i to c
        {
            this.currentSequence.add(initialString.charAt(c) + "");
            this.code.add(c);
            String theBits ;
            theBits = Integer.toBinaryString(c);
            theBits = new String(new char[(5 - theBits.length())]).replace("\0", "0") + theBits;
            this.bits.add(theBits);
        }
    }

    public String output(String t)
    {
        int index = 0;
        boolean check = false;
        String full = "";
        String result = "";
        String conjecture = "";
        String outputSequence = "";

        do
        {
            outputSequence = getSequence(t, index);

            //index = getCodeSize(this.code);

           if(this.code.size() < 32)
            {
                index = index + 5;
            }
            else
            {
                index = index + 6;
            }

            full = conjecture + outputSequence.substring(0, 1);
            if (isSequenceExist(full) == -1)
            {
                this.currentSequence.add(full);
                this.code.add(this.code.size());
                this.bits.add(Integer.toBinaryString(this.bits.size()));
            }
            conjecture = outputSequence;
            result += outputSequence;
            if (!getSequence(t, index).equals("#"))
            {
                check = true;
            }
            else
            {
                check = false;
            }
        } while(check);
        result += "#";
        return result;
    }
//Gets sequence for string which takes two parameters
    private String getSequence(String inputString, int index)
    {

        int stringLength;
        //stringLength = getCodeSize(this.code);


        if(this.code.size() < 32)
        {
            stringLength = 5;
        }
        else
        {
            stringLength = 6;
        }

        String theBits = inputString.substring(index, index + stringLength);
        int code = Integer.parseInt(theBits, 2);
        String curSequence = this.currentSequence.get(code);
        return curSequence;
    }

    private int isSequenceExist(String str)
    {
        for (int i = 0; i < this.currentSequence.size(); i++)
        {
            if (str.equals(this.currentSequence.get(i)))
            {
                return i;
            }
        }
        return -1;
    }

  int getCodeSize(LinkedList<Integer> code){
        if(code.size() < 32)   {
            return 5;
        }
        else {

            return 6;
        }
    }

}
