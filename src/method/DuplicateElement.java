package method;
public class DuplicateElement {
    static Object [] findDuplicateElements(Object[]dataArray){
       Object [] duplicateElements = new Object [dataArray.length];
       for(int i = 0 ; i< dataArray.length; i++){
           for(int j = i + 1 ; j < dataArray.length; j++){
               if(dataArray[i].equals(dataArray[j])){
                   duplicateElements[i] = dataArray[i];
                   break;
               }else{
                     duplicateElements[i] = null;
               }
           }
       }
       return duplicateElements;
    }
    public static void main(String[] args) {
            Object [] dataArray = { "Apple", "Mango", "Orange", "Apple", "Blue berry", "Mango", "Berry" ,"Orange"};
            Object [] duplicateElements = findDuplicateElements(dataArray);
            for(Object element : duplicateElements){
                if(element != null){
                    System.out.println("Duplicate Element: " + element);
                }
        }
    }
}
