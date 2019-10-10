import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Datenbank {
	
	private String db_Mail = "Mail";
	private String db_Vorname = "Vorname";
	private String db_Nachname = "Nachname";
	private String db_Passwort = "PW";
	
	private String db_Name_User = "User";

	public boolean ErstelleUser(String pMail, String pVorname, String pNachname, String pPasswort)
	{
		//User in DB speichern
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Superkalender.sqlite");
            Statement stat = conn.createStatement();
            String sql = "INSERT INTO "+db_Name_User+" ("+db_Mail+", "+db_Vorname+", "+db_Nachname+", "+db_Passwort+") VALUES (" + pMail + ",'" + pVorname + "'," + pNachname+ "'," + pPasswort + ")";
            int rs = stat.executeUpdate(sql);
            conn.close();
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
	}
	
	public boolean MailVorhanden(String pMail)
	{
		boolean vorhanden = true;
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Superkalender.sqlite");
            Statement stat = conn.createStatement();
            String sql = "Select Count(*) from "+db_Name_User+" WHERE "+db_Mail+" = '" + pMail + "*";
            ResultSet rs = stat.executeQuery(sql);

            if (rs.getFetchSize() == 0)
            {
            	vorhanden = false;
            }

            rs.close();
            conn.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return vorhanden;
	}
	
	public boolean Login(String pMail, String pPasswort)
	{
		boolean result = false;
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Superkaldender.sqlite");
            Statement stat = conn.createStatement();
            String sql = "Select "+db_Passwort+" from "+db_Name_User+" WHERE "+db_Mail+" = '"+pMail+"'";
            ResultSet rs = stat.executeQuery(sql);

            if(rs.getString(db_Passwort).equals(pPasswort))
            {
            	result = true;
            }
            
            rs.close();
            conn.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
		return result;
	}
	
	public void ErstelleEintrag()
	{
		
	}
	
	
	


	
}
