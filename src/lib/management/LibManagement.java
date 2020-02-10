
package lib.management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class LibManagement implements MyVariables
{
    public static void main(String[] args) 
    {
        try
     {
       Connection myconnection=DriverManager.getConnection(PATH+PLACE,USERNAME,PASSWORD);
        try
        {
            String myquery="select name from signup";
            PreparedStatement mystatement=myconnection.prepareStatement(myquery);
            ResultSet myresult=mystatement.executeQuery();
            if(myresult.next())
            {
                Login obj=new Login();
                obj.setVisible(true);
            }
            else
            {
                AdminSignup obj=new AdminSignup();
                obj.setVisible(true);
            }
        }
        catch(Exception et)
        {
            JOptionPane.showMessageDialog(null, "Error in querry due to "+et.getMessage());
        }
        finally
        {
            myconnection.close();
        }
     }
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(null, "Error in connection due to "+e.getMessage());
     }
    }
}
