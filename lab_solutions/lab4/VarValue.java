public class VarValue {
    private String name;
    private String dataType;
    private float rvalue;
    private int ivalue;

    public VarValue(String nm, String dt) {
        name = new String(nm);
        dataType = new String(dt);
        rvalue = 0;
        ivalue = 0;
    }

    public void SetValue(String val) {
        if (dataType.equals("int")) {
            ivalue = Integer.parseInt(val);
        }
        else {
            // it is of type float 
            rvalue = Float.parseFloat(val);
        }
    }

    public String toString() {
        if (dataType.equals("int")) {
            return String.format("%-5s %-6s", dataType, ivalue);
        }
        else {
            return String.format("%-5s %-6s", dataType, rvalue);
        }
    } 
} 
