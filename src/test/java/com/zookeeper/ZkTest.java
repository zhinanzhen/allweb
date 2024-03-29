package com.zookeeper;

import org.apache.zookeeper.*;

/**
 * @ClassName ZkTest
 * @Description
 * @Author xiangnan.xu
 * @DATE 2018/1/2 16:08
 */
public class ZkTest {
    public static void main(String[] args) throws Exception{
        ZooKeeper zk = new ZooKeeper("106.14.161.165:2181", 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("已经触发了" + event.getType() + "事件！" + event.getPath());
            }
        });

        // 创建一个目录节点
        zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath", false, null)));

        // 创建一个子目录节点
        zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath/testChildPathOne", true, null)));


        // 取出子目录节点列表
        System.out.println(zk.getChildren("/testRootPath", true));

        // 修改子目录节点数据
        zk.setData("/testRootPath/testChildPathOne", "modifyChildDataOne".getBytes(), -1);
        System.out.println(new String(zk.getData("/testRootPath/testChildPathOne", false, null)));
        System.out.println("目录节点状态：[" + zk.exists("/testRootPath", true) + "]");

        // 创建另外一个子目录节点
        zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo", false, null)));

        // 删除子目录节点
        zk.delete("/testRootPath/testChildPathTwo", -1);
        zk.delete("/testRootPath/testChildPathOne", -1);

        // 删除父目录节点
        zk.delete("/testRootPath", -1);
        // 关闭连接
        zk.close();
    }
}
