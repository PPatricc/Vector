import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        double[] vector1;
        double[] vector2;
        boolean flag = false;
        do
        {
            do
            {
                System.out.println("Enter 1st vector: ");
                String input1 = scan.nextLine();
                String[] split1 = input1.split(" ");
                vector1 = new double[split1.length];
                try
                {
                    for(int i=0;i<split1.length;i++)
                    {
                        vector1[i] = Double.parseDouble(split1[i]);
                    }
                    flag = false;
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Error in Vector 1! " + e + "\n  This is not a number, please enter a new vector: ");
                    flag = true;
                }
            }while(flag);
            do
            {
                System.out.println("Enter the 2 vector: ");
                String input2 = scan.nextLine();
                String[] split2 = input2.split(" ");
                vector2 = new double[split2.length];
                try
                {
                    for(int i=0;i<split2.length;i++)
                    {
                        vector2[i] = Double.parseDouble(split2[i]);
                    }
                    flag = false;
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Error in Vector 2! " + e + "\n  This is not a number, please enter a new vector: ");
                    flag = true;
                }
            }while(flag);
            try
            {
                VectorsAdd(vector1, vector2);
            }
            catch(WektoryRoznejDlugosciException e)
            {
                System.out.println("Vectors of different lengths are given! Exception: " + e);
            }
        }while(vector1.length != vector2.length);
        scan.close();
    }

    static private void VectorsAdd(double[] v1, double[] v2) throws WektoryRoznejDlugosciException
    {
        if(v1.length != v2.length)
        {
            throw new WektoryRoznejDlugosciException(v1.length, v2.length);
        }
        double[] result = new double[v1.length];
        for(int i=0; i < v1.length; i++)
        {
            result[i] = v1[i] + v2[i];
        }
        try
        {
            PrintWriter writer = new PrintWriter("vector1.txt");
            for(int i=0;i<v1.length;i++)
            {
                writer.print(result[i]+" ");
            }
            writer.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error! File not found! " + e);
        }
        System.out.print("Vector Saved!\n");
    }
}

class WektoryRoznejDlugosciException extends Exception
{
    public WektoryRoznejDlugosciException(double v1, double v2)
    {
        System.out.println("Length of 1 Vector: " + v1);
        System.out.println("Length of 2 Vector: " + v2);
    }
}