// Andrew Lewin
package a07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListVsSetDemo {
	List<ColoredSquare> list;
	Set<ColoredSquare> set;
	StringBuilder sb = new StringBuilder();
	
	public ListVsSetDemo(ColoredSquare... elements) {
		this.list = new ArrayList<>(Arrays.asList(elements));
		this.set = new HashSet<>(Arrays.asList(elements));
	}
	
	public String getListElements() {
        sb.setLength(0);
        for (ColoredSquare element : list){
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
     
    public String getSetElements() {
        sb.setLength(0);
        for (ColoredSquare element : set){
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
     
     public void addElement(ColoredSquare el){
         list.add(el);
         set.add(el);
     }
	
}
