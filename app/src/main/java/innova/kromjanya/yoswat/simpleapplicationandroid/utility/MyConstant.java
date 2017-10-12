package innova.kromjanya.yoswat.simpleapplicationandroid.utility;

/**
 * Created by ThinkPad on 12/10/2560.
 */

public class MyConstant {

    private String hostString = "ftp.swiftcodingthai.com";
    private String userString = "ino@swiftcodingthai.com";
    private String passwordString = "Abc12345";
    private int portAnint = 21;

    private String urlPostuser = "http://swiftcodingthai.com/ino/addUserBoat.php";
    private String urlGetData = "http://swiftcodingthai.com/ino/getAllDataBoat.php";

    public String getUrlGetData() {

        return urlGetData;
    }

    public String getUrlPostuser() { return urlPostuser; }

    public String getHostString() { return hostString; }

    public String getUserString() { return userString; }

    public String getPasswordString() { return passwordString; }

    public int getPortAnint() { return portAnint; }
}
