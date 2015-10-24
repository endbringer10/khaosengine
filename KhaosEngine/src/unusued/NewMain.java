package unusued;

/**
 *
 * @author endbringer10
 * @since 20151024 
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewSettings.load();
        System.out.println(NewSettings.DEBUG.parseBoolean());
        NewSettings.DEBUG.setValue(false);
        System.out.println(NewSettings.DEBUG.parseBoolean());
    }

}//End Class
