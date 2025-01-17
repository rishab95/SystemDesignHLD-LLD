//import org.apache.zookeeper.*;
//
//import java.io.IOException;
//
//public class ZooKeeperExample {
//
//    private static final String ZOOKEEPER_ADDRESS = "127.0.0.1:2181"; // Replace with your ZooKeeper address
//    private static final int SESSION_TIMEOUT = 3000; // 3 seconds
//    private static ZooKeeper zooKeeper;
//
//    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
//        // Connect to ZooKeeper
//        zooKeeper = new ZooKeeper(ZOOKEEPER_ADDRESS, SESSION_TIMEOUT, event -> {
//            if (event.getState() == Watcher.Event.KeeperState.SyncConnected) {
//                System.out.println("Connected to ZooKeeper!");
//            }
//        });
//
//        // Wait for connection establishment
//        Thread.sleep(1000);
//
//        // Create a znode
//        String path = "/example";
//        String data = "Hello ZooKeeper!";
//        createZNode(path, data.getBytes());
//
//        // Get znode data
//        String znodeData = getZNodeData(path);
//        System.out.println("Data in znode: " + znodeData);
//
//        // Update znode data
//        updateZNodeData(path, "Updated Data".getBytes());
//        System.out.println("Updated data in znode: " + getZNodeData(path));
//
//        // Delete the znode
//        deleteZNode(path);
//
//        // Close ZooKeeper connection
//        zooKeeper.close();
//        System.out.println("ZooKeeper connection closed!");
//    }
//
//    // Create a znode
//    public static void createZNode(String path, byte[] data) throws KeeperException, InterruptedException {
//        if (zooKeeper.exists(path, false) == null) {
//            zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//            System.out.println("ZNode created at: " + path);
//        } else {
//            System.out.println("ZNode already exists at: " + path);
//        }
//    }
//
//    // Retrieve data from a znode
//    public static String getZNodeData(String path) throws KeeperException, InterruptedException {
//        return new String(zooKeeper.getData(path, false, null));
//    }
//
//    // Update znode data
//    public static void updateZNodeData(String path, byte[] data) throws KeeperException, InterruptedException {
//        zooKeeper.setData(path, data, -1);
//        System.out.println("ZNode data updated at: " + path);
//    }
//
//    // Delete a znode
//    public static void deleteZNode(String path) throws KeeperException, InterruptedException {
//        if (zooKeeper.exists(path, false) != null) {
//            zooKeeper.delete(path, -1);
//            System.out.println("ZNode deleted at: " + path);
//        } else {
//            System.out.println("ZNode does not exist at: " + path);
//        }
//    }
//}
