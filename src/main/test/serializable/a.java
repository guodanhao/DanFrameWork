package serializable;

import java.io.Serializable;

/**
 * Created by muxi on 2016/10/5.
 */
public class a implements Serializable{


    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {

        return "this is a";
    }

//    public String argu1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
//
//    public String argu2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
//
//    public String argu3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

    String[] arg = new String[102400];
}
