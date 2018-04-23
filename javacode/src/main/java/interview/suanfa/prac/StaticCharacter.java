package interview.suanfa.prac;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/29<p>
// I am a student a boy”
// [(I,1),(a,2),(am,1),(boy,1),(student,1)]
// -------------------------------------------------------
public class StaticCharacter {

    private static final String pattern = "\\s+";

    public static void main(String[] args) {
        String original = "I am  a student a   boy";

        Iterable<String> result = Splitter.onPattern(pattern).omitEmptyStrings().trimResults().split(original);

        List<String> spliterList = Lists.newArrayList(result);

        TreeMap<String,Integer> resultMap = Maps.newTreeMap();
        for(String originString:spliterList){
            if(resultMap.get(originString)==null){
                resultMap.put(originString,1);
            }else {
                resultMap.put(originString,(resultMap.get(originString)+1));
            }
        }
        System.out.printf("[");
        for(Map.Entry<String,Integer> entry:resultMap.entrySet()){
            System.out.printf("("+entry.getKey()+","+entry.getValue()+")");
        }
        System.out.printf("]");
    }

}
