package main;

import java.io.IOException;

/**
 * Class <b>Translation</b>
 *
 * @author Mykyta Frolov
 *
 * @version 1.0
 *
 */
class Translation {
    /**
     * @param word The word that will be translated
     *
     * @return soon will return translation, at this time only copied word for test
     *
     */
    static String tranlate(String word) throws IOException {
        /*String result= "";
        String link = "http://api.lingualeo.com/gettranslates?word=" + "'" + word + "'";
        Scanner s = new Scanner(new URL(link).openStream());
        BufferedReader in = new BufferedReader(
                new InputStreamReader(new URL(link).openStream()));
        String inputLine = in.readLine();
        String[] array = inputLine.split("}");
        if(array.length < 6) {
            for (int i = 1; i < array.length - 1; i++) {
                result = result.concat(array[i].substring(array[i].indexOf("value") + 8, array[i].indexOf("votes") - 3)+'\n');
            }
        }
//        System.out.println(result);
        if (result.equals("")){
            return "Empty";
        }*/
    return word;
        }
    }



