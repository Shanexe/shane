package cn.hxh.storage.interfaces;

import cn.hxh.object.Diary;

import java.util.List;

public interface DiaryData {

    boolean delete(Diary.Key date);

    boolean create(Diary diary);

    boolean update(Diary diary);

    Diary query(Diary.Key date);

    List<String> query(int year, int month);

    List<String> queryAll();

    void cleanAndInit();
}
