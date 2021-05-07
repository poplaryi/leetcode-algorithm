package com.yangyi.code.spi;

import com.yangyi.code.spi.Search;

/**
 * @author kcyangyi@gmail.com
 */
public class FileSearch implements Search {
    @Override
    public void searchDoc(String key) {
        System.out.println("文件搜索" + key);
    }
}
