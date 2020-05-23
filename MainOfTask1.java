import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class MainOfTask1 {
    public static void main(String[] args) throws IOException {
        String id = "173762912";
        URL  url =
                new URL(
                        "https://api.vk.com/method/friends.get?user_id="+id+"&v=5.74&access_token=28b9b30a28b9b30a28b9b30a5c28cbacbd228b928b9b30a7671a6a67c3c67ea3ceda9df");
        InputStreamReader is  = new InputStreamReader( url.openStream());
        BufferedReader b = new BufferedReader(is);

        String k = b.readLine();
        int n = Integer.parseInt(k.split("count\":")[1].split(",")[0]);

        k = k.split("\\[")[1].split("\\]")[0];

        String [] friends = k.split(",");
        String [] myActivity = activity(id);
        Set<String> clearFriends = new HashSet<>();
        for (String s: friends) {
            String [] friendsActivity = activity(s);
            boolean c = false;
            int i = 0;
            while(!c && i < myActivity.length) {
                int j =0;
                while(!c && j < friendsActivity.length) {
                    if(myActivity[i].equals(friendsActivity[j])) {
                        clearFriends.add(s);
                        c = true;
                    }
                    j++;
                }
                i++;
            }


        }



    }

    public static String [] activity (String s) {
        return  null;

    }
}
