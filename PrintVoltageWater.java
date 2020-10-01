
package printvoltagewater;

/**
 * Author: Christian Vincent (N01393413)
 * Last edited: 9/23/2018
 * Description: This program calculates and prints the voltmeter reading of an 
 * electric circuit given the temperature from 0 to 100 Celsius in increments 
 * of 10.
 */
public class PrintVoltageWater {
    
        final static int INIT_RESISTANCE = 50;          //R0
        final static double K = 0.5;
        final static int SENSOR_RESISTANCE = 75;        //Rs
        final static int SENSOR_VOLTAGE = 20;           //Vs
        
    public static void main(String[] args) {
       
        double resistor;
        double voltmeterVoltage;
        int temp;                                       //temp in Celsius
        
        System.out.println("The following is a list of voltage readings\n" +
                           "for an electric circuit designed to measure the\n" +
                           "temperature of water (in Celsius).\n");
        System.out.println("T\t vm");
        System.out.println("------ ------");
        
        for(temp = 0; temp <=100; temp = temp + 10)
        {
           resistor = calcResistance(temp); 
           voltmeterVoltage = calcVolt (resistor);
           
           System.out.print(temp + "\t");
           System.out.format("%.2f%n", voltmeterVoltage);
           
        }
    
}

 //Calculates the resistance   
public static double calcResistance(int temp)
{
    return INIT_RESISTANCE + K * temp;
}

//Calculates the voltage reading of the voltmeter
public static double calcVolt(double resistor)
{
    return (resistor / (SENSOR_RESISTANCE + resistor)) * SENSOR_VOLTAGE;
}

}
    

