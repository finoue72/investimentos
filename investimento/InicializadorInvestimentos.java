/*
 * Created on 15/08/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package investimento;

import java.util.Timer;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author Deus
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InicializadorInvestimentos {
  
    
    public static void main(String[] args) throws InterruptedException {
        try{
           // lerConfiguracao();
           InvestimentosFrame bovespaFrame = new InvestimentosFrame();
           
           bovespaFrame.setVisible(true);
           
           
            
        }catch(Exception e){
            //e.printStackTrace();
        }
        
    }
}
