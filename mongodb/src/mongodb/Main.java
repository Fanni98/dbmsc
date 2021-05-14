package mongodb;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class Main {
	public static void main(String[] args) {
		Book book = createUser();
		DBObject doc = createDBObject(book);
		MongoClient mongo = new MongoClient("localhost", 65535);
		DB db = mongo.getDB("AB_MSC_JNHQE0");
		DBCollection col = db.getCollection("books");

		// create
		WriteResult result = col.insert(doc);
		DBObject query = BasicDBObjectBuilder.start().add("title", book.getTitle()).get();
		DBCursor cursor = col.find();

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

		// update
		book.setTitle("SZJG");
		doc = createDBObject(book);
		result = col.update(query, doc);

		// delete
		result = col.remove(query);

	}



	private static DBObject createDBObject(Book book) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("title", book.getTitle());
		docBuilder.append("author", book.getAuthor());
		docBuilder.append("year", book.getYear());
		return docBuilder.get();

	}

	private static Book createUser() {
		Book b = new Book();
		b.setTitle("Szent Johanna Gimi");
		b.setAuthor("Leiner Laura");
		b.setYear(2010);
		return b;
	}

}
