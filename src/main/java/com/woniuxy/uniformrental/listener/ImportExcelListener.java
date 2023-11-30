package com.woniuxy.uniformrental.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.extension.toolkit.Db;

import java.util.ArrayList;
import java.util.List;

public class ImportExcelListener<T> extends AnalysisEventListener<T> {
    //创建一个集合保存所有导入的数据
    private List<T> list = new ArrayList<>();
    //声明业务对象
    private Class<T> entity;
    private boolean row;

    //处理每一条数据
    @Override
    public void invoke(T s, AnalysisContext analysisContext) {
        //将每条数据添加到集合中
        list.add(s);
    }

    //所有数据导入完成以后的操作
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //写入到数据库中
        row = Db.saveBatch(list);
    }

    //获取插入的行数
    public boolean getRow() {
        return row;
    }
}

