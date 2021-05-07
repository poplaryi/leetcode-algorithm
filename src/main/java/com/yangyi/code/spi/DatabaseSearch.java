package com.yangyi.code.spi;

import com.yangyi.code.spi.Search;

/**
 * @author kcyangyi@gmail.com
 */
public class DatabaseSearch implements Search {
    @Override
    public void searchDoc(String key) {
        System.out.println("数据库搜索" + key);
    }
}
