import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.InvalidPropertiesFormatException;

import android_serialport_api.Application;
import android_serialport_api.SerialPort;

/**
 * Created by 陆伟 on 17/10/30.
 */

public class MainApplication extends Application {
    private SerialPort mSerialPort = null;

    public  SerialPort getmSerialPort() throws  SecurityException,IOException,InvalidParameterException{
        if(null == mSerialPort){
            String path = "/dev/tty2";
            int baufrate = 115000;
            if(path.length() == 0 || baufrate == -1){
                throw  new InvalidParameterException();
            }
            mSerialPort = new SerialPort(new File(path),baufrate,0);

        }
        return  mSerialPort;
    }

    public void closeSerialPort(){
        if(mSerialPort != null){
            mSerialPort.close();
            mSerialPort = null;
        }

    }

}
