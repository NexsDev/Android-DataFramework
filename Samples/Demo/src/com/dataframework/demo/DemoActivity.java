package com.dataframework.demo;

import java.util.List;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.android.dataframework.DataActivity;
import com.android.dataframework.DataFramework;
import com.android.dataframework.Entity;
import com.android.dataframework.entity.Comment;
import com.android.dataframework.entity.Post;
import com.android.dataframework.entity.User;

public class DemoActivity extends DataActivity {

	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);
		textView = (TextView)findViewById(R.id.textView1);
		
		// You can get entity using the table name and the 1 of the entity
		Entity eUser1 = new Entity("user", 1);

		//To create a record in a table you just need to instance a new entity from a table without an id
		//Lets make a new post
		Entity ePost = new Entity("post");
		ePost.setValue("text", "My first post using Data framework!");
		ePost.setValue("user_id", eUser1.getId());
		ePost.save();
		
		//Making a comment
		Entity eComment = new Entity("comment");
		eComment.setValue("text", "and this your first comment! yay!");
		eComment.setValue("user_id", eUser1.getId());
		eComment.setValue("post_id", ePost.getId());
		eComment.save();

		// You can make updates
		eComment.setValue("text", "Changed comment!");
		eComment.save();

		// To get all my post you can run a query from our DataFramework
		// instance
		addLine("-------------------");
		addLine("List of post from user1");
		addLine("-------------------");
		List<Entity> ePosts = DataFramework.getInstance().getEntityList("post", "user_id = 1");
		for (Entity entity : ePosts) {
			addLine(entity.getString("text"));
			List<Entity> eComments = DataFramework.getInstance().getEntityList("comment", "post_id =" + entity.getId());
			for (Entity entity2 : eComments) {
				addLine(" - " + entity2.getString("text"));
			}
		}

		// Or you can do the same using the entity creator
		User user2 = new User(2);

		Post post = new Post();
		post.setText("And this is a new post from a generated class");
		post.setUserId(user2.getId());
		post.save();

		Comment comment = new Comment();
		comment.setText("And i comment using the same!");
		comment.setUserId(user2.getId());
		comment.save();

		// And get all the post casted to your entity class
		addLine("-------------------");
		addLine("List of post from user2");
		addLine("-------------------");
		List<Post> posts = DataFramework.getInstance().getEntityList(Post.class,"user_id = 2");
		for (Post bean : posts) {
			addLine(bean.getText());
			List<Comment> comments = DataFramework.getInstance().getEntityList(Comment.class, "post_id =" + bean.getId());
			for (Comment entity2 : comments) {
				addLine(" - " + entity2.getText());
			}
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.demo, menu);
		return true;
	}
	
	private void addLine(String line){
		textView.setText(textView.getText().toString() + "\n" + line);
	}
	

}
