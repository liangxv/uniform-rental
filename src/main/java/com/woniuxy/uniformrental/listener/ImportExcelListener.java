package com.woniuxy.uniformrental.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ImportExcelListener<T, S> extends AnalysisEventListener<T> {
    // 创建一个集合保存所有导入的数据
    private List<T> list = new ArrayList<>();

    Method saveBatchMethod;
    // 声明业务对象
    private S service;

    public ImportExcelListener(Class<T>  clazz, Class<S> serviceClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

            // 实例化serviceClass对象
            service = serviceClass.getDeclaredConstructor().newInstance();

            // 获取saveBatch方法
            saveBatchMethod = serviceClass.getMethod("saveBatch", List.class);



    }

    // 处理每一条数据
    @Override
    public void invoke(T data, AnalysisContext context) {
        // 将每条数据添加到集合中
        list.add(data);
    }

    // 所有数据导入完成以后的操作
    @SneakyThrows
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 写入到数据库中
        // 调用saveBatch方法
        saveBatchMethod.invoke(service, list);
        // 其他处理逻辑...
    }

    // 获取插入的行数
    public int getRow() {
        return list.size();
    }
}

