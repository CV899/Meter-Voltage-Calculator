
package wireresistance;

/**
 * Author: Christian Vincent (N01393413)
 * Last edited: 9/24/2018
 * Description: This program takes input for wire gauge and wire length, then
 * calculates the resistance of a copper and aluminum wire.
 * 
 */
import java.util.Scanner;

public class WireResistance {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int wireGauge;
        double diameter;
        double length;
        double copperResistance;
        double alumResistance;
        
        System.out.println("This program calculates the resistance of"
                + " a copper and aluminum wire given the wire gauge"
                + " and length.\n");
        
        System.out.print("Enter the wire gauge: ");
        wireGauge = input.nextInt();
        //validate wireGauge input
        while(wireGauge <= 0)
        {
            System.out.println("Please enter a valid number.");
            System.out.print("Enter the wire gauge: ");
            wireGauge = input.nextInt();
        }
        
        System.out.print("Enter the wire length in inches: ");
        length = input.nextDouble();
        //validate length input
        while(length <= 0)
        {
            System.out.println("Please enter a valid number.");
            System.out.print("Enter the wire length in inches: ");
            length = input.nextDouble();
        }
        
        //Calculate diameter, copper resistance, and aluminum resistance
        diameter = computeDiameter(wireGauge);
        copperResistance = computeCopperWireResistance(length, diameter);
        alumResistance = computeAlumResistance(length, diameter);
        
        //Print results
        System.out.print("The resistance of a " + (int)length + " inch piece of " +
                wireGauge + " gauge copper wire is ");
        System.out.format("%.3f Ohms.%n", copperResistance);
        System.out.print("The resistance of a " + (int)length + " inch piece of " +
                wireGauge + " gauge aluminum wire is ");
        System.out.format("%.3f Ohms.%n", alumResistance);
        
        
}
 
//Computes and returns the diameter of the wire based on the wire
//gauge value.
public static double computeDiameter(int wireGauge)
{ 
   return 0.127 * Math.pow(92.0, (36.0 - wireGauge) / 39.0);  
}

//Computes and returns the resistance of the copper wire.
public static double computeCopperWireResistance(double length, double diameter)
{   
    //Copper resistivity in Ohms mm
    final double COPPER_RESISTIVITY = 1.678E-5;
    final double INCHES_TO_MM_CONVERTER = 25.4;
    
    //Convert length in inches to mm
    length = length * INCHES_TO_MM_CONVERTER; 
   
    return (4.0 * COPPER_RESISTIVITY * length) / (Math.PI * Math.pow(diameter, 2.0));
    
}

//Computes and returns the resistance of the aluminum wire.
public static double computeAlumResistance(double length, double diameter)
{
    //Aluminum resistivity in Ohms mm
    final double ALUM_RESISTIVITY = 2.82E-5;
    final double INCHES_TO_MM_CONVERTER = 25.4;
    
    //Convert length in inches to mm
    length = length * INCHES_TO_MM_CONVERTER;
    
    return (4.0 * ALUM_RESISTIVITY * length) / (Math.PI * Math.pow(diameter, 2.0));
}


}
   
