package com.learning.java8.learning.designPattern.composite.safe;

/**
 * 组合模式——安全合成，将对象组合成树形结构以表示“部分-整体”的层次结构。
 * 使得用户对单个对象和组合对象的使用具有一致性。
 *
 * 安全式合成模式的缺点是不够透明，因为树叶类和树枝类将具有不同的接口。
 */
public interface Component {

    void printStruct();

}
