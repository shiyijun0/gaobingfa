package cn.bdqn.gaobingfa.config;

import java.util.ArrayList;
import java.util.List;
//@Slf4j
//@Component
public class WordsConfig  { //implements ApplicationContextInitializer
    // 集合中保存所有成语
    private  List<String> words = new ArrayList<String>();
   /* @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        // 初始化阶段，读取new_words.txt
        // web工程中读取 文件，必须使用绝对磁盘路径
       // String path = getServletContext().getRealPath("/doc/new_words.txt");
       // BufferedReader reader = new BufferedReader(new FileReader(path));
        try {
            Reader path= Resources.getResourceAsReader("doc/new_words.txt");
            BufferedReader reader=new BufferedReader(path);
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
            reader.close();
        }catch (IOException e){

        }

    }*/


    public  List<String> getWords() {
        return words;
    }

    public  void setWords(List<String> words) {
        this.words = words;
    }
}
