package thinking.in.java.chaptertwo.prac;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/11/5<p>
// -------------------------------------------------------
public class ObjectInit {
    int intVlaue;
    String StringValue;

    public int getIntVlaue() {
        return intVlaue;
    }

    public void setIntVlaue(int intVlaue) {
        this.intVlaue = intVlaue;
    }

    public String getStringValue() {
        return StringValue;
    }

    public void setStringValue(String stringValue) {
        StringValue = stringValue;
    }

    public static void main(String[] args) {
        // int init value is 0;String init value is null;
        ObjectInit objectInit = new ObjectInit();
        System.out.println("intInitValue=" + objectInit.intVlaue);
        System.out.println("initStringValue=" + objectInit.StringValue);
    }
}
