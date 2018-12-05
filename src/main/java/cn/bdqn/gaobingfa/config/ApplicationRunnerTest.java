package cn.bdqn.gaobingfa.config;

import org.apache.ibatis.io.Resources;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationRunnerTest implements ApplicationRunner {
    // 集合中保存所有成语
    private List<String> words = new ArrayList<String>();
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner");
            // 初始化阶段，读取new_words.txt
            // web工程中读取 文件，必须使用绝对磁盘路径
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
    }

    @Bean
    public WordsConfig list(){
        WordsConfig wordsConfig=new WordsConfig();
        wordsConfig.setWords(words);
        return wordsConfig;
    }
}
