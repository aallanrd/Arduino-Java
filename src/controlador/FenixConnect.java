// Code Communication on Arduino Based on 
// http://www.drdobbs.com/jvm/control-an-arduino-from-java/240163864
// Eric Bruno , Dr. Dobb's Bloggers


package controlador;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 * @author ericjbruno
 */
public class FenixConnect implements SerialPortEventListener {
   
    SerialPort serialPort = null;

    private final String PORT_NAME =  "COM6";
    
    private String appName;
    private BufferedReader input;
    private OutputStream output;
    
    private static final int TIME_OUT = 1000; // Port open timeout
    private static final int DATA_RATE = 9600; // Arduino serial port

    public boolean initialize() {
        try {
            CommPortIdentifier portId = null;
            Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

         
            
            while (portId == null && portEnum.hasMoreElements()) {
                
                CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
               
              
                    if ( currPortId.getName().equals(PORT_NAME) 
                      || currPortId.getName().startsWith(PORT_NAME)) {

                        
                        serialPort = (SerialPort)currPortId.open(appName, TIME_OUT);
                        portId = currPortId;
                        //System.out.println( "Connected on port: " + currPortId.getName() );
                        break;
                    }
                
            }
        
            if (portId == null || serialPort == null) {
                System.out.println("Oops... Could not connect to Arduino");
                return false;
            }
        
            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                            SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1,
                            SerialPort.PARITY_NONE);

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);

            // Give the Arduino some time
            try { Thread.sleep(100); } catch (InterruptedException ie) {}
            
            return true;
        }
        catch ( Exception e ) { 
            e.printStackTrace();
        }
        return false;
    }
    
    public void sendData(String data) {
        try {
            //System.out.println("Sending data: '" + data +"'");
            
            // open the streams and send the "y" character
            output = serialPort.getOutputStream();
            output.write( data.getBytes() );
        } 
        catch (Exception e) {
            System.err.println(e.toString());
            System.exit(0);
        }
    }

    //
    // This should be called when you stop using the port
    //
    public synchronized void close() {
        if ( serialPort != null ) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    public static FenixTipadas fenix = new FenixTipadas();
    //
    // Handle serial port event
    //
    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        //System.out.println("Event received: " + oEvent.toString());
        try {
            switch (oEvent.getEventType() ) {
                case SerialPortEvent.DATA_AVAILABLE: 
                    if ( input == null ) {
                        input = new BufferedReader(
                            new InputStreamReader(
                                    serialPort.getInputStream()));
                    }
                    
                    String inputLine = input.readLine();
                    FenixTipadas.gettingData.add(inputLine);
                   System.out.println("@serialEvent: "+inputLine);
                    break;

                default:
                    break;
            }
        } 
        catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public FenixConnect() {
        appName = getClass().getName();
    }
    
   
}



