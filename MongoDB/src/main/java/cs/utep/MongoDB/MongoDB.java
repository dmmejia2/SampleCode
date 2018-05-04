package cs.utep.MongoDB;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDB {

	public static void Main(String[] args) {
		System.out.println("Sup");
		MongoClientURI uri = new MongoClientURI("mongodb://dmmejia2:mongodb@el-paso-traffic-shard-00-00-lgoto.mongodb.net:27017,el-paso-traffic-shard-00-01-lgoto.mongodb.net:27017,el-paso-traffic-shard-00-02-lgoto.mongodb.net:27017/admin?ssl=true&replicaSet=el-paso-traffic-shard-0&authSource=admin");

		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("test");
	}


}
