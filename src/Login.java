import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Login {

    HashMap<String,String> userLogins ;
    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    Login() throws Exception {

        String path = System.getProperty("user.dir");
        String[] buyerInfos = readFileAsString(path.concat("/src/DataBase/BuyerInfo.txt")).split("\\R");
        String[] sellerInfos = readFileAsString(path.concat("/src/DataBase/SellerInfo.txt")).split("\\R");
        userLogins = new HashMap<>();
        for (String buyerInfo : buyerInfos) {
            String user[] = buyerInfo.split(":");
            userLogins.put(user[0], user[1]);
        }
        for (String sellerInfo : sellerInfos) {
            String user[] = sellerInfo.split(":");
            userLogins.put(user[0], user[1]);
        }
    }

    public boolean login( String name, String password) {

        if (userLogins.containsKey(name) && userLogins.get(name).equals(password)) {
            return true;
        }
        return false;
    }
}
