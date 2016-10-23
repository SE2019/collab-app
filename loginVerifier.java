public class loginVerifier {

    public static boolean main(String user, String pass, String[] database) {
        String userpass = user+pass;
        for (String n : database) {   
            if (userpass.equals(n)) {
                return true;
            } 
        }

	return false;
    }
}