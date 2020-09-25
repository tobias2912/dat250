package no.hvl.dat110.rest.counters;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

import static spark.Spark.*;

/**
 * Rest api for a Todo class with CRUD operations
 */
public class App {

    static ArrayList<Todo> allTodos = new ArrayList<>();

    public static void main(String[] args) {

        if (args.length > 0) {
            port(Integer.parseInt(args[0]));
        } else {
            port(8080);
        }

        Todo test = new Todo(1, "abc", "summmm");
        allTodos.add(test);

        after((req, res) -> {
            res.type("application/json");
        });

        get("/counters", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(allTodos);
        });

        post("/counters", (req, res) -> {
            //should get a unique id
            Gson gson = new Gson();
            Todo newtodo = gson.fromJson(req.body(), Todo.class);
            int id = newtodo.getId();
            for (Todo todo : allTodos) {
                if (todo.getId() == id) {
                    //not unique id
                    return "error: not unique";
                }
            }
            allTodos.add(newtodo);
            return gson.toJson(allTodos);
        });
		put("/counters", (req, res) -> {
			//should get a existing id
			Gson gson = new Gson();
			Todo newtodo = gson.fromJson(req.body(), Todo.class);
			int id = newtodo.getId();
			for (Todo todo : allTodos) {
				if (todo.getId() == id) {
					//delete and update
					allTodos.remove(todo);
					allTodos.add(newtodo);
					return gson.toJson(allTodos);
				}
			}
			return "error: did not find id";
		});

        delete("/counters", (req, res) -> {
            //should only get an id and delete all matching occurences
            Gson gson = new Gson();
            Map<String, Double> map = gson.fromJson(req.body(), Map.class);
            System.out.println(map);
            int deleteid = (map.get("id")).intValue();
            System.out.println(deleteid);
            for (Todo todo : allTodos) {
                if (todo.getId() == deleteid) {
                    allTodos.remove(todo);
                    break;
                }
            }
            return gson.toJson(allTodos);
        });

    }

}
