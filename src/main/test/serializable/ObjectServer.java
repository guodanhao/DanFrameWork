package serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by muxi on 2016/10/5.
 */
public class ObjectServer {

    public static void main(String[] args) throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\a.obj"));
        out.writeObject(new a());
        out.close();
    }
}
