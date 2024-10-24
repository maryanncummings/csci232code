
public class IntHash {  
    public static void main(String[] args)  
    {  
        //Create integer object  
        Integer i = new Integer("-155");  
        //Returned hash code value for this object   
        int hashValue = i.hashCode();  
        System.out.println("Hash code Value for object is: " + hashValue);  
    }  
}
